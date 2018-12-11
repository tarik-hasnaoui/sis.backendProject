
package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_result")
public class ExamResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Exam exam;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private StudentProfile studentProfile;

	private Double grade;

	private int ects;

	public ExamResult() {
	}

	public ExamResult(Exam exam, StudentProfile studentProfile, Double grade, int ects) {
		this.exam = exam;
		this.studentProfile = studentProfile;
		this.grade = grade;
		this.ects = ects;
	}

	public Long getId() {
		return id;
	}
        
	public void setId(Long id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public StudentProfile getStudentProfile() {
		return studentProfile;
	}

	public void setStudentProfile(StudentProfile studentProfile) {
		this.studentProfile = studentProfile;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public int getEcts() {
		return ects;
	}

	public void setEcts(int ects) {
		this.ects = ects;
	}

}
