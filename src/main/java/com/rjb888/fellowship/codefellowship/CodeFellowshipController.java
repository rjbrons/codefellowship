package com.rjb888.fellowship.codefellowship;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

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

   @GetMapping("/signup")
   public String getLogin(){
      return "SignUp";
   }

   @PostMapping("/signup")
    public RedirectView signUp(@RequestParam String userName,
                               @RequestParam String password,
                               @RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String dateOfBirth,
                               @RequestParam String bio){
       ApplicationUser newUser = new ApplicationUser(userName,
               password, firstName, lastName, dateOfBirth,
               bio);
       System.out.println(newUser);
       applicationUserRepository.save(newUser);
       return new RedirectView("/");
   }

}
