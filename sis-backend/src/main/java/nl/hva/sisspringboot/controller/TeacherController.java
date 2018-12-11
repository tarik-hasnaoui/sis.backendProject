
package nl.hva.sisspringboot.controller;

import java.util.Date;
import java.util.List;

import nl.hva.sisspringboot.model.ExamResult;
import nl.hva.sisspringboot.model.Module;
import nl.hva.sisspringboot.model.SchoolYear;
import nl.hva.sisspringboot.model.StudentProfile;
import nl.hva.sisspringboot.model.UserProfile;
import nl.hva.sisspringboot.service.ExamResultService;
import nl.hva.sisspringboot.service.ExamService;
import nl.hva.sisspringboot.service.ModuleService;
import nl.hva.sisspringboot.service.SchoolYearService;
import nl.hva.sisspringboot.service.StudentProfileService;
import nl.hva.sisspringboot.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamResultService examResultService;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private StudentProfileService studentProfileService;

    @Autowired
    private SchoolYearService schoolYearService;

    @GetMapping("/teacher/{token}/getAllUsers")
    public List<StudentProfile> getAllUsers(@PathVariable String token) {
        return teacherService.getAllUsers(token, Long.MIN_VALUE);
    }

    @GetMapping("/teacher/{token}/getSingleProfile")
    public UserProfile getUserProfileById(@PathVariable String token, @RequestParam("id") Long id) {
        return studentProfileService.getUserProfileById(id);
    }

    @GetMapping("/teacher/{token}/getExamResults")
    public List<ExamResult> getExamResults(@PathVariable String token, @RequestParam("id") Long id) {
        return examService.getExams(token, id);
    }

    @GetMapping("/teacher/{token}/getAllModules")
    public List<Module> getAllModules(@PathVariable String token) {
        return moduleService.getAllModules(token);
    }

    @GetMapping("/teacher/{token}/getAllSchoolYears")
    public List<SchoolYear> getAllSchoolYears(@PathVariable String token) {
        return schoolYearService.getSchoolYears(token);
    }

    @PostMapping(value = "/teacher/{token}/saveGrade")
    public void saveGrade(@PathVariable String token, @RequestBody ExamResult examResult) {
        StudentProfile profile = studentProfileService.getStudentProfile(Long.valueOf(token));
        Module module = moduleService.getModule(examResult.getExam().getModule().getId());
        examResult.setStudentProfile(profile);
        examResult.setEcts(module.getEcts());
        examResult.getExam().setDate(new Date());
        examResultService.save(examResult);
    }

    @PostMapping(value = "/teacher/{token}/deleteExam")
    public void deleteExam(@PathVariable String token, @RequestBody ExamResult examResult) {
        examResultService.delete(examResult);
    }

}
