
package nl.hva.sisspringboot.dao;

import java.util.List;
import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.model.ExamRegistration;
import nl.hva.sisspringboot.model.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRegistrationDao extends JpaRepository<ExamRegistration, Long>{
    
    public List<ExamRegistration> findByBlockAndStudentProfile(Block block, StudentProfile studentProfile);
}
