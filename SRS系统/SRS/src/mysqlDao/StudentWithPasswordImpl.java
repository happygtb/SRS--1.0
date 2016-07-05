package mysqlDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.StudentWithPasswordDao;
import model.Student;
import model.StudentWithPassword;
import util.DBUtil;

public class StudentWithPasswordImpl implements StudentWithPasswordDao {
	@Override
	public StudentWithPassword getStudentWithPassword(String Sssn) {
		StudentWithPassword sp = new StudentWithPassword();
		Connection Conn = DBUtil.getMySqlConnection();
		String sql = "select * from Student where Sssn='" + Sssn + "'";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String pwd = rs.getString("password");
				Student student = new Student(rs.getString("studentName"), Sssn, rs.getString("major"),rs.getString("degree"));
				sp = new StudentWithPassword(student, pwd);
			}
			rs.close();
			pstmt.close();
			Conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}

	@Override
	public void updatePasswordOfStudent(String Sssn, String pwd) {
		Connection conn = DBUtil.getMySqlConnection();
		String sql = "update Student set password='" + pwd + "' where Sssn='" + Sssn + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("¸üÐÂÊ§°Ü" + e.getMessage());
		}
	}
}
