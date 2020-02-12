package application.models.colaborador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.DBConnector;

public class ColaboradorDAO {

	public static ArrayList<Colaborador> getColaboradores() {
		ArrayList<Colaborador> colaboradores = new ArrayList<>();
		Connection conn = DBConnector.getConnection("","","");
		String sql = "";
		try(Statement stat = conn.createStatement(); ResultSet rs = stat.executeQuery(sql)){
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				TipoId tipoId = TipoId.valueOf(rs.getInt(3));
				String nId = rs.getString(4);
				String address = rs.getString(5);
				String cellphone = rs.getString(6);
				String email = rs.getString(7);
				String imagePath = rs.getString(8);
				String cvPath = rs.getString(9);
				colaboradores.add(new Colaborador(id, name, tipoId, nId, address,
						cellphone, email, imagePath, cvPath));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return colaboradores;
	}
}
