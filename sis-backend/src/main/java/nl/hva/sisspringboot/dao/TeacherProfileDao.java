
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.TeacherProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherProfileDao extends JpaRepository<TeacherProfile, Long> {
    
}
