
package nl.hva.sisspringboot.controller;

import java.util.List;

import nl.hva.sisspringboot.model.Block;
import nl.hva.sisspringboot.model.ExamRegistration;
import nl.hva.sisspringboot.model.ExamResult;
import nl.hva.sisspringboot.model.UserProfile;
import nl.hva.sisspringboot.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @GetMapping("/user/{token}/profile")
    public UserProfile getUserProfile(@PathVariable String token) {
        return studentProfileService.getUserProfile(token, 1L);
    }

    @GetMapping("/user/{token}/result/all")
    public List<ExamResult> getUserResults(@PathVariable String token) {
        return studentProfileService.getExamResults(token);
    }

    @PostMapping("/user/{token}/exam")
    public List<ExamRegistration> getStudentExams(@PathVariable String token, @RequestBody Block block) {
        return studentProfileService.getStudentExams(token, block);
    }
}
