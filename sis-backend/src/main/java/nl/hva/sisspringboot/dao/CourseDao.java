
package nl.hva.sisspringboot.dao;

import nl.hva.sisspringboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long>{
    
}
