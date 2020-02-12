package application.models.colaborador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.DBConnector;

public class ColaboradorDAO {

	public static ArrayList<Colaborador> getColaboradores() {
		ArrayList<Colaborador> colaboradores = new ArrayList<>();
		Connection conn = DBConnector.getConnection("", "", "");
		String sql = "  ";
		try (Statement stat = conn.createStatement(); ResultSet rs = stat.executeQuery(sql)) {
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				TipoId tipoId = TipoId.valueOf(rs.getInt(3));
				String nId = rs.getString(4);
				String address = rs.getString(5);
				String cellphone = rs.getString(6);
				String email = rs.getString(7);
				String imagePath = rs.getString(8);
				String cvPath = rs.getString(9);
				colaboradores.add(new Colaborador(id, name, tipoId, nId, address, cellphone, email, imagePath, cvPath));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colaboradores;
	}

	public static void insertColaborador(Colaborador colaborador) {
		Connection conn = DBConnector.getConnection("","","");
		String sql = "";
		try(PreparedStatement stat = conn.prepareStatement(sql)){
			stat.setString(1, colaborador.getId());
			stat.setString(2, colaborador.getName());
			stat.setString(3, String.valueOf(colaborador.getTipoId()));
			stat.setString(4, colaborador.getnId());
			stat.setString(5, colaborador.getAddress());
			stat.setString(6, colaborador.getCellphone());
			stat.setString(7, colaborador.getEmail());
			stat.setString(8, colaborador.getImagePath());
			stat.setString(9, colaborador.getCvPath());
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void removeColaborador(Colaborador colaborador) {
		Connection conn = DBConnector.getConnection("", "", "");
		String sql = "";
		try (PreparedStatement stat = conn.prepareStatement(sql)) {
			stat.setString(1, colaborador.getId());
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