
package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
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
@Table(name = "semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int semesterNumber;

    private Date startDate;

    private Date endDate;

    @OneToMany(mappedBy = "semester", fetch = FetchType.EAGER)
    private List<Block> blocks;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    private SchoolYear schoolYear;

    public Semester(int semesterNumber, Date startDate, Date endDate, List<Block> blocks, SchoolYear schoolYear) {
        this.semesterNumber = semesterNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.blocks = blocks;
        this.schoolYear = schoolYear;
    }

    public Semester() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
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

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public SchoolYear getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(SchoolYear schoolYear) {
        this.schoolYear = schoolYear;
    }

}
