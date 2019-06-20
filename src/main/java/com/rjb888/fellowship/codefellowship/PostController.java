package com.rjb888.fellowship.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

public class PostController {

    @Autowired
    PostRepository postRepository;


    @PostMapping("/myprofile")
    public RedirectView addPost(Principal p, Model m){
        m.addAttribute("principal", p);
        //create a new Post entity
            //gather necessary params
        
        //save the entity to the db
        //redirect to page
        return new RedirectView("/myprofile");
    }
}
