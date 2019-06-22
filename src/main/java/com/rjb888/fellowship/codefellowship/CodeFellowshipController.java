package com.rjb888.fellowship.codefellowship;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.WebParam;
import java.security.Principal;

@Controller
public class CodeFellowshipController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

   @GetMapping("/")
   public String getHome(){ return "Home";}

   @GetMapping("/codefellowship")
   public String getCodeFellowship(){
        return "Code Fellowship";
    }
    @GetMapping("/login")
    public String getLogin(){
       return "Login";
    }
   @GetMapping("/signup")
   public String getSignUp(Principal p, Model m){
       ApplicationUser loggedIn = applicationUserRepository.findByUsername(p.getName());
       m.addAttribute("user", loggedIn);
      return "SignUp";
   }
   @GetMapping("/users")
    public String myProfile(Principal p, Model m){
       Iterable<ApplicationUser> userList = applicationUserRepository.findAll();
       m.addAttribute("users", userList);
       m.addAttribute("principal", p);
       return "UserProfile";
   }
}
