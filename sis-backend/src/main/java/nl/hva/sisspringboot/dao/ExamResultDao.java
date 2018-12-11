
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamResultDao extends JpaRepository<ExamResult, Long>{
    
}
