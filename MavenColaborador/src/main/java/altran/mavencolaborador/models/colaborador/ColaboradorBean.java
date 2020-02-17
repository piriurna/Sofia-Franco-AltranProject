package altran.mavencolaborador.models.colaborador;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import altran.mavencolaborador.DBConnector;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ColaboradorBean{
	private static DBConnector dbConnector = DBConnector.getConnector();

	// Busca a lista de todos colaboradores da base de dados
	public static ArrayList<Colaborador> getColaboradores() {
		ArrayList<Colaborador> colaboradores = new ArrayList<>();
		Connection conn = dbConnector.getConnection();
		ResultSet rs = null;
		String sql = "{ ? = call CONSULTARLISTACOLABORADORES }";
		try (CallableStatement cstmt = conn.prepareCall(sql)){
			//Registra o parametro de saida como um cursor
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			
			//Depois de enviar a query busca o cursor e guarda no result set
			rs = (ResultSet) ((OracleCallableStatement) cstmt).getCursor(1);
			//Percorre todas as linhas do result e 
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String morada = rs.getString(3);
				String cc = rs.getString(4);
				Date birthday = rs.getDate(5);
				String email = rs.getString(6);
				String tlm = rs.getString(7);
				FileInputStream photo = (FileInputStream) rs.getBlob(8);
				FileInputStream cv = (FileInputStream) rs.getBlob(9);
				colaboradores.add(new Colaborador(id, name, morada, cc, birthday, email, tlm, photo, cv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colaboradores;
	}

	// Busca colaborador com o Cartao de cidadao especificado
	public static Colaborador getColaborador(String cartaoCidadao) {
		Colaborador colaborador = null;
		Connection conn = dbConnector.getConnection();
		String sql = "CALL CONSULTCOLABORADOR(?,?,?,?,?,?,?,?)";
		try (CallableStatement stat = conn.prepareCall(sql)) {

			// Define os parametros OUT
			stat.registerOutParameter(1, Types.VARCHAR);
			stat.registerOutParameter(2, Types.VARCHAR);
			stat.registerOutParameter(3, Types.VARCHAR);
			stat.registerOutParameter(4, Types.DATE);
			stat.registerOutParameter(5, Types.VARCHAR);
			stat.registerOutParameter(6, Types.VARCHAR);
			stat.registerOutParameter(7, Types.BLOB);
			stat.registerOutParameter(8, Types.BLOB);

			// Define os parametros IN
			stat.setString(3, cartaoCidadao);

			// Envia a Query com os parametros já definidos
			stat.execute();

			// Cria as variáveis para criar o colaborador
			String name = stat.getString(1);
			String morada = stat.getString(2);
			String cc = stat.getString(3);
			Date birthday = stat.getDate(4);
			String email = stat.getString(5);
			String tlm = stat.getString(6);
			FileInputStream photo = (FileInputStream) stat.getBlob(7);
			FileInputStream cv = (FileInputStream) stat.getBlob(8);

			// Cria o colaborador com os parametros recebidos
			colaborador = new Colaborador("0", name, morada, cc, birthday, email, tlm, photo, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// Devolve o colaborador recebido
		return colaborador;
	}

	// Inserir ou modificar colaborador (Verificado atraves do cartaoDeCidadao)
	public static int updateColaborador(Colaborador colaborador) {
		Connection conn = dbConnector.getConnection();
		int rs = 0;
		String sql = "call UPDATE_COLABORADOR(?, ?, ?, ?, ?, ?, ?, ?)";
		try (CallableStatement stat = conn.prepareCall(sql)) {

			// Define os parametros para atulizacao
			stat.setString(1, colaborador.getName());
			stat.setString(2, colaborador.getAddress());
			stat.setString(3, colaborador.getnId());
			stat.setDate(4, colaborador.getBirthday());
			stat.setString(5, colaborador.getEmail());
			stat.setString(6, colaborador.getCellphone());
			stat.setBlob(7, colaborador.getImagePath());
			stat.setBlob(8, colaborador.getCvPath());

			// Envia a Query com os parametros já definidos
			// e devolve o numero de linhas modificadas
			rs = stat.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}

	// Deleta o colaborador com o cartaoDeCidadao especificado
	public static void deleteColaborador(String cc) {
		Connection conn = dbConnector.getConnection();
		String sql = "CALL REMOVERCOLABORADOR(?)";
		try (CallableStatement stat = conn.prepareCall(sql)) {
			stat.setString(1, cc);
			stat.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}