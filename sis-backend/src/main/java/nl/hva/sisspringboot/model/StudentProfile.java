package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("S")
@Table(name = "stduent_profile")
public class StudentProfile extends UserProfile {

    @Column(unique = true)
    private String studentNumber;

    private Date registrationDate;

    private Date unsubscriptionDate;

    private String previousDegree;

    @JsonIgnore
    @OneToMany(mappedBy = "studentProfile")
    private List<ExamResult> examResults;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private CourseGroup courseGroup;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.MERGE)
    private CourseProgram courseProgram;

    @JsonIgnore
    @OneToMany(mappedBy = "studentProfile")
    private Set<ExamRegistration> examRegistrations;

    public StudentProfile() {

    }

    public StudentProfile(String studentNumber, Date registrationDate, Date unsubscriptionDate, String previousDegree, List<ExamResult> examResults, CourseGroup courseGroup, CourseProgram courseProgram, char gender, String initials, String firstName, String lastName, String insertion, String phoneNumber, Date dateOfBirth, String placeOfBirth, String training, String nationality, Address address) {
        super(gender, initials, firstName, lastName, insertion, phoneNumber, dateOfBirth, placeOfBirth, training, nationality, address);
        this.studentNumber = studentNumber;
        this.registrationDate = registrationDate;
        this.unsubscriptionDate = unsubscriptionDate;
        this.previousDegree = previousDegree;
        this.examResults = examResults;
        this.courseGroup = courseGroup;
        this.courseProgram = courseProgram;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getUnsubscriptionDate() {
        return unsubscriptionDate;
    }

    public void setUnsubscriptionDate(Date unsubscriptionDate) {
        this.unsubscriptionDate = unsubscriptionDate;
    }

    public String getPreviousDegree() {
        return previousDegree;
    }

    public void setPreviousDegree(String previousDegree) {
        this.previousDegree = previousDegree;
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public CourseGroup getCourseGroup() {
        return courseGroup;
    }

    public void setCourseGroup(CourseGroup courseGroup) {
        this.courseGroup = courseGroup;
    }

    public CourseProgram getCourseProgram() {
        return courseProgram;
    }

    public void setCourseProgram(CourseProgram courseProgram) {
        this.courseProgram = courseProgram;
    }

    public Set<ExamRegistration> getExamRegistrations() {
        return examRegistrations;
    }

    public void setExamRegistrations(Set<ExamRegistration> examRegistrations) {
        this.examRegistrations = examRegistrations;
    }

}
