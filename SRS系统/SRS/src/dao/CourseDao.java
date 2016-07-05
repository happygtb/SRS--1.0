package dao;

import java.util.List;

import model.Course;
import model.Section;

public interface CourseDao {
	List<Course> getAllCourses();
	Course getCourse(String courseNo);
	List<Course> getPrerequisites(Course course);
	List<Section> getAllOfferedAsSection(Course course);
	void addPrerequisite(String courseNo, String preCourseNo);
	void addCourse(Course course,String preCourseNo);
	void updateCourse(Course course);
	void deleteCourse(String courseNo);
	void updatePrerequisite(Course course, String preCourseNo);
}
