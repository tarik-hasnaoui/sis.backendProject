package nl.hva.sisspringboot.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("T")
@Table(name = "teacher_profile")
public class TeacherProfile extends UserProfile {

}
