package nl.hva.sisspringboot.controller;

import java.util.List;

import nl.hva.sisspringboot.model.Course;
import nl.hva.sisspringboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author User
 */
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/{token}/getAllCourses")
    public List<Course> getAllCourses(@PathVariable String token) {
        return courseService.getAllCourses(token, Long.MIN_VALUE);
    }

    @PostMapping(value = "/course/{token}/addCourse")
    public void addCourse(@PathVariable String token, @RequestBody Course course) {
        //Todo return code.
        courseService.addCourse(token, course);
    }

    @PostMapping(value = "/course/{token}/deleteCourse")
    public void deleteCourse(@PathVariable String token, @RequestBody Course course) {
        System.out.println("Delete course");
        courseService.deleteCourse(token, course);
    }
}
