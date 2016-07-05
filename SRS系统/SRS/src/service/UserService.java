package service;

import dao.ProfessorWithPasswordDao;
import dao.StudentWithPasswordDao;
import dao.dataAccess;
import model.ProfessorWithPassword;
import model.StudentWithPassword;

public class UserService {
	public StudentWithPassword getStudentWithPassword(String sssn){
		StudentWithPasswordDao spd=dataAccess.createStudentWithPasswordDao();
		StudentWithPassword sp=spd.getStudentWithPassword(sssn);
		return sp;
	}
	
	public ProfessorWithPassword getProfessorWithPassword(String pssn){
		ProfessorWithPasswordDao ppd=dataAccess.createProfessorWithPasswordDao();
		ProfessorWithPassword pp=ppd.getProfessorWithPassword(pssn);
		return pp;
	}
}
