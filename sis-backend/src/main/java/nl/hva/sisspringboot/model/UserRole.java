package nl.hva.sisspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	@Enumerated(EnumType.STRING)
	private UserRoleType userRoleName;

	public UserRole(UserRoleType userRoleName) {
		this.userRoleName = userRoleName;
	}

	public UserRole() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserRoleType getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(UserRoleType userRoleName) {
		this.userRoleName = userRoleName;
	}

}
