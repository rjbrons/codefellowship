package com.rjb888.fellowship.codefellowship;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.WebParam;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class ApplicationUserController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/signup")
    public RedirectView signUp(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String dateOfBirth,
                               @RequestParam String bio){
        ApplicationUser newUser = new ApplicationUser(username,
                bCryptPasswordEncoder.encode(password),
                firstName, lastName, dateOfBirth, bio);
        applicationUserRepository.save(newUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }

    @GetMapping("/myprofile")
    public String myProfile(Principal p, Model m){
        ApplicationUser me = applicationUserRepository.findByUsername(p.getName());
        m.addAttribute("user", me);
        return "MyProfile";
    }

    @GetMapping("/user/{id}")
    public String singleUser(@PathVariable long id, Model m){
        ApplicationUser thisUser = applicationUserRepository.findById(id).get();
        m.addAttribute("user", thisUser);
        return "SingleUser";
    }

}
