package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_program")
public class CourseProgram {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private Course course;

	@OneToMany(mappedBy = "courseProgram")
	private List<SchoolYear> courseYears;

	public CourseProgram(Course course, List<SchoolYear> courseYears) {
		this.course = course;
		this.courseYears = courseYears;
	}

	public CourseProgram() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public List<SchoolYear> getCourseYears() {
		return courseYears;
	}

	public void setCourseYears(List<SchoolYear> courseYears) {
		this.courseYears = courseYears;
	}

}
