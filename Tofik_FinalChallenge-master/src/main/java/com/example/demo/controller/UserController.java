package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.model.auth.AppUser;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService users;

    @RequestMapping("/")
    public String showProfile(Model model, Authentication authentication){
        AppUser thisUser = users.findUser(authentication);
//        if (thisUser.hasProfile())
            model.addAttribute("profile", users.findProfile(authentication));
//        else
//        {
////            model.addAttribute("noProfile", true);
////            model.addAttribute("profile", new Profile());
//            return "profileform";
//        }
        return "profile";
    }

    @GetMapping("/form")
    public String getProfile(Model model, Authentication authentication){
        AppUser thisUser = users.findUser(authentication);
//        if (!thisUser.hasProfile())
//            model.addAttribute("profile", new Profile());
//        else
            model.addAttribute("profile", users.findProfile(authentication));
        return "profileform";
    }
    @PostMapping("/form")
    public String saveProfile(@ModelAttribute("profile") Profile profile, Authentication authentication){
        users.saveProfile(profile, authentication);
        return "redirect:/user/";
    }
}