
package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course_group")
public class CourseGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String groupCode;

	@JsonIgnore
	@OneToMany
	private List<UserProfile> userProfiles;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "school_year_id", nullable = false)
	private SchoolYear schoolYear;

	public CourseGroup(String groupCode, List<UserProfile> userProfiles, SchoolYear schoolYear) {
		this.groupCode = groupCode;
		this.userProfiles = userProfiles;
		this.schoolYear = schoolYear;
	}

	public CourseGroup() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public SchoolYear getSchoolYear() {
		return schoolYear;
	}

	public void setSchoolYear(SchoolYear schoolYear) {
		this.schoolYear = schoolYear;
	}

}
