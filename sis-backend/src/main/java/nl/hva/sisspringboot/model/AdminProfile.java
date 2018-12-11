package nl.hva.sisspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("A")
@Table(name = "admin_profile")
public class AdminProfile extends UserProfile {

}
