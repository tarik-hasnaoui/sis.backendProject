
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExamDao extends JpaRepository<Exam, Long>{
    
}
