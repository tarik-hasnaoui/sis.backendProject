
package nl.hva.sisspringboot.controller;

import nl.hva.sisspringboot.model.ExamRegistrationBasket;
import nl.hva.sisspringboot.service.ExamRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamRegistrationController {

    @Autowired
    private ExamRegistrationService examRegistrationService;

    @PostMapping("/user/{token}/basket")
    public ExamRegistrationBasket saveBasket(@PathVariable String token, @RequestBody ExamRegistrationBasket examRegistrationBasket) {
        return examRegistrationService.saveBasket(token, examRegistrationBasket);
    }

    @PutMapping("/user/{token}/basket")
    public ExamRegistrationBasket updateBasket(@PathVariable String token, @RequestBody ExamRegistrationBasket examRegistrationBasket) {
        return examRegistrationService.updateBasket(token, examRegistrationBasket);
    }

    @DeleteMapping("/user/{token}/basket")
    public void deleteBasket(@PathVariable String token, @RequestBody ExamRegistrationBasket examRegistrationBasket) {
        examRegistrationService.deleteBasket(token, examRegistrationBasket);
    }
}
