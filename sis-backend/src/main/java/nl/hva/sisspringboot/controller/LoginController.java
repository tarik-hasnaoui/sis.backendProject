
package nl.hva.sisspringboot.controller;

import nl.hva.sisspringboot.model.User;
import nl.hva.sisspringboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;


    @PostMapping(value = "/user/login")
    public User login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/user/reset")
    public String resetUser(@RequestBody User user) {
        return loginService.resetUser(user);
    }

}
