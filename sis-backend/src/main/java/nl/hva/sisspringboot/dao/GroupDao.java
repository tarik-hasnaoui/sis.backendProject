
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.CourseGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupDao extends JpaRepository<CourseGroup, Long>{
    
}
