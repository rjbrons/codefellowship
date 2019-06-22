package com.rjb888.fellowship.codefellowship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    PostRepository postRepository;


    @PostMapping("/myprofile")
    public RedirectView addPost(Principal p, Model m, String body){
        m.addAttribute("principal", p);
        //create a new Post entity
            //gather necessary params
        Post newPost = new Post(body, new Date());
        newPost.setOwner(applicationUserRepository.findByUsername(p.getName()));
        //save the entity to the db
        postRepository.save(newPost);
        //redirect to page
        return new RedirectView("/myprofile");
    }
}
