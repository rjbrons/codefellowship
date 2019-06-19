package com.rjb888.fellowship.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam String userName,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String dateOfBirth,
                               @RequestParam String bio){
        ApplicationUser newUser = new ApplicationUser(userName,
                bCryptPasswordEncoder.encode(password),
                firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        return new RedirectView("/");
    }

}
