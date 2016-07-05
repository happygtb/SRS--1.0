package dao;

import model.ProfessorWithPassword;

public interface ProfessorWithPasswordDao {
	ProfessorWithPassword getProfessorWithPassword(String Pssn);
	void updatePasswordOfProfessor(String Pssn, String pwd);
}
