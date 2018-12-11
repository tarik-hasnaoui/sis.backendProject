package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "exam_registration")
public class ExamRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Exam exam;
    
    @JsonIgnore
    @OneToOne
    private Block block;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private StudentProfile studentProfile;
    
    @Column(columnDefinition="tinyint(1) default 0")
    private Boolean isRegistered;
    
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private ExamRegistrationLineItem examRegistrationLineItem;

    public ExamRegistration(Exam exam, Block block, StudentProfile studentProfile, boolean isRegistered) {
        this.exam = exam;
        this.block = block;
        this.studentProfile = studentProfile;
        this.isRegistered = isRegistered;
    }

    public ExamRegistration() {
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

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public boolean isIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(boolean isRegistered) {
        this.isRegistered = isRegistered;
    }
    
}
