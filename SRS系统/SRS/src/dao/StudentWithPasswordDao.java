package dao;

import model.StudentWithPassword;

public interface StudentWithPasswordDao {
	StudentWithPassword getStudentWithPassword(String Sssn);
	void updatePasswordOfStudent(String Sssn, String pwd);
}
