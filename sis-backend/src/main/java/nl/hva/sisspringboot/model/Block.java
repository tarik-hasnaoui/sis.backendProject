
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
@Table(name = "block")
public class Block {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Integer blockNumber;

	private Date startDate;

	private Date endDate;

	@OneToMany(fetch=FetchType.EAGER)
	private List<Module> modules;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	private Semester semester;

	public Block(Integer blokNumber, Date startDate, Date endDate, List<Module> modules, Semester semester) {
		this.blockNumber = blokNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modules = modules;
		this.semester = semester;
	}

	public Block() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBlokNumber() {
		return blockNumber;
	}

	public void setBlokNumber(Integer blokNumber) {
		this.blockNumber = blokNumber;
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

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Integer getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(Integer blockNumber) {
		this.blockNumber = blockNumber;
	}

}
