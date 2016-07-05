package model;

public class StudentWithPassword extends Student {
	private String password;

	public StudentWithPassword(String name, String ssn, String major, String degree, String password) {
		super(name, ssn, major, degree);
		this.setPassword(password);
	}

	public StudentWithPassword(Student student, String password) {
		super(student.getName(), student.getSsn(), student.getMajor(), student.getDegree());
		this.setPassword(password);
	}

	public StudentWithPassword() {
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public Student getStudent() {
		Student s = new Student(this.getName(), this.getSsn(), this.getMajor(), this.getDegree());
		return s;
	}

	public boolean validatePassword(String pw) {
		if (pw.equals(password))
			return true;
		else
			return false;
	}
}
