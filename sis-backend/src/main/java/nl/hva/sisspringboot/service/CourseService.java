
package nl.hva.sisspringboot.service;

import java.util.List;
import nl.hva.sisspringboot.dao.CourseDao;
import nl.hva.sisspringboot.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDAO;
    

    public List<Course> getAllCourses(String token, Long id) {
        return  courseDAO.findAll();
    }
    
    public void addCourse(String token, Course course) {
       courseDAO.save(course);
    }
    
    public void deleteCourse(String token, Course course) {
       courseDAO.delete(course);
    }
}
