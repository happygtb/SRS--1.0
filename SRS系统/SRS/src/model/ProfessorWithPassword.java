package model;

public class ProfessorWithPassword extends Professor {
	private String password;

	public ProfessorWithPassword(String name, String ssn, String major, String degree, String password) {
		super(name, ssn, major, degree);
		this.setPassword(password);
	}

	public ProfessorWithPassword(Professor professor, String password) {
		super(professor.getName(), professor.getSsn(), professor.getTitle(), professor.getDepartment());
		this.setPassword(password);
	}

	public ProfessorWithPassword() {
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Professor getProfessor() {
		Professor p = new Professor(this.getName(), this.getSsn(), this.getTitle(), this.getDepartment());
		return p;
	}

	public boolean validatePassword(String pw) {
		if (pw.equals(password))
			return true;
		else
			return false;
	}
}
