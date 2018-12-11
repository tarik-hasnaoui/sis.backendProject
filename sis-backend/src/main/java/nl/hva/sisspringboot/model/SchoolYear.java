
package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "school_year")
public class SchoolYear {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int yearNumber;

	private Date startDate;

	private Date endDate;

	@OneToMany(mappedBy = "schoolYear", fetch=FetchType.EAGER)
	private Set<Semester> semesters;

	@OneToMany(mappedBy = "schoolYear")
	private List<CourseGroup> courseGroups;

	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	private CourseProgram courseProgram;

	public SchoolYear(int yearNumber, Date startDate, Date endDate, Set<Semester> semesters, List<CourseGroup> courseGroups, CourseProgram courseProgram) {
		this.yearNumber = yearNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.semesters = semesters;
		this.courseGroups = courseGroups;
		this.courseProgram = courseProgram;
	}

	public SchoolYear() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYearNumber() {
		return yearNumber;
	}

	public void setYearNumber(int yearNumber) {
		this.yearNumber = yearNumber;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(Set<Semester> semesters) {
		this.semesters = semesters;
	}

	public List<CourseGroup> getGroups() {
		return courseGroups;
	}

	public void setGroups(List<CourseGroup> groups) {
		this.courseGroups = groups;
	}

	public List<CourseGroup> getCourseGroups() {
		return courseGroups;
	}

	public void setCourseGroups(List<CourseGroup> courseGroups) {
		this.courseGroups = courseGroups;
	}

	public CourseProgram getCourseProgram() {
		return courseProgram;
	}

	public void setCourseProgram(CourseProgram courseProgram) {
		this.courseProgram = courseProgram;
	}

}
