
package nl.hva.sisspringboot.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String courseCode;

	private String coursename;

	@Enumerated(EnumType.STRING)
	private CourseType courseType;

	private Integer ects;

	@OneToMany(mappedBy = "course")
	private List<CourseProgram> coursePrograms;

	public Course(String courseCode, String coursename, CourseType courseType, Integer ects, List<CourseProgram> coursePrograms) {
		this.courseCode = courseCode;
		this.coursename = coursename;
		this.courseType = courseType;
		this.ects = ects;
		this.coursePrograms = coursePrograms;
	}

	public Course() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public Integer getEcts() {
		return ects;
	}

	public void setEcts(Integer ects) {
		this.ects = ects;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

	public List<CourseProgram> getCoursePrograms() {
		return coursePrograms;
	}

	public void setCoursePrograms(List<CourseProgram> coursePrograms) {
		this.coursePrograms = coursePrograms;
	}

}
