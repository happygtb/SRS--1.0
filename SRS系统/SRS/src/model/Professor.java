package model;

import java.util.ArrayList;

public class Professor extends Person {

	private String title;
	private String department;
	private ArrayList<Section> teaches;

	public Professor(String name, String ssn, String title, String dept) {

		super(name, ssn);

		setTitle(title);
		setDepartment(dept);

		teaches = new ArrayList<Section>();
	}

	public Professor() {
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setDepartment(String dept) {
		department = dept;
	}

	public String getDepartment() {
		return department;
	}

	public void agreeToTeach(Section s) {
		teaches.add(s);

		s.setInstructor(this);
	}
}
