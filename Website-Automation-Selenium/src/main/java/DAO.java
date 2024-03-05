import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	public int addUser(User user) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConn();
		String sql = "SELECT * FROM user WHERE email=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		String testEmail = "";
		while (rs.next())
			testEmail = (rs.getString("email"));
		if (!testEmail.equals(""))
			return 0;
		String sqlInsert = "INSERT INTO user VALUES(?,?,?,?)";
		PreparedStatement ps2 = conn.prepareStatement(sqlInsert);
		ps2.setString(1, user.getFirstName());
		ps2.setString(2, user.getLastName());
		ps2.setString(3, user.getEmail());
		ps2.setString(4, user.getPassword());

		return ps2.executeUpdate();

	}

	public boolean validateLogin(String email, String password) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getConn();
		String sql = "SELECT * FROM user WHERE email=? AND password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		String testUserName = "";
		while (rs.next()) {
			testUserName = (rs.getString("first_name"));
			
		}
		if (!testUserName.equals(""))
			return true;
		return false;

	}
}
