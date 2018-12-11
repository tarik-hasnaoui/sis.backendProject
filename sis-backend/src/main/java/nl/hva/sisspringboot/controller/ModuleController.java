package nl.hva.sisspringboot.controller;

import java.util.List;

import nl.hva.sisspringboot.model.Module;
import nl.hva.sisspringboot.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/module/{token}/getAllModules")
    public List<Module> getAllCourses(@PathVariable String token) {
        return moduleService.getAllModules(token);
    }

    @PostMapping(value = "/module/{token}/addModule")
    public void addCourse(@PathVariable String token, @RequestBody Module module) {
        moduleService.addModule(token, module);
    }

    @PostMapping(value = "/module/{token}/deleteModule")
    public void deleteCourse(@PathVariable String token, @RequestBody Module module) {
        moduleService.deleteModule(token, module);
    }

}
