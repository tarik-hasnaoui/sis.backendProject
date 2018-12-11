
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterDao extends JpaRepository<Semester, Long>{
    
}
