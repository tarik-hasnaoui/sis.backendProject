
package nl.hva.sisspringboot.controller;

import java.util.List;

import nl.hva.sisspringboot.model.SchoolYear;
import nl.hva.sisspringboot.service.SchoolYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolYearController {

    @Autowired
    private SchoolYearService schoolYearService;

    @GetMapping("/user/{token}/schoolyears")
    public List<SchoolYear> getSchoolYears(@PathVariable String token) {
        return schoolYearService.getSchoolYears(token);
    }

}
