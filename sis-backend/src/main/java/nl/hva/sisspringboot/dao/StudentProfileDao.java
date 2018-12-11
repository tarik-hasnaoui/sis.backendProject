
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProfileDao extends JpaRepository<StudentProfile, Long> {

}
