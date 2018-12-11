
package nl.hva.sisspringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "token")
	private String token;

	@Column(name = "is_enabled", columnDefinition = "INT(1) default 1")
	private boolean isEnabled;

	@Column(name = "lastLogin")
	private Date lastLogin;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private UserProfile userProfile;

	@OneToOne(cascade = CascadeType.MERGE)
	private UserRole userRole;

	public User(String email, String password, String token, boolean isEnabled, Date lastLogin, UserProfile userProfile, UserRole userRole) {
		this.email = email;
		this.password = password;
		this.token = token;
		this.isEnabled = isEnabled;
		this.lastLogin = lastLogin;
		this.userProfile = userProfile;
		this.userRole = userRole;
	}

	public User() {

	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public boolean isIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}
