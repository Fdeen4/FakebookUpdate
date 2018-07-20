package com.example.demo.controller;

import com.example.demo.model.Profile;
import com.example.demo.model.auth.AppUser;
import com.example.demo.model.auth.AppUserRepository;
import com.example.demo.model.auth.UserRoleRepository;
import com.example.demo.model.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class AuthController {
    @Autowired
    AppUserRepository users;

    @Autowired
    UserRoleRepository roles;

    @Autowired
    ProfileRepository profileRepository;

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String regiter(Model model) {
        model.addAttribute("newUser", new AppUser());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("newUser") AppUser user, Model model) {

        if(users.existsByUsername(user.getUsername())){
            model.addAttribute("usernameErr", users.existsByUsername(user.getUsername()));
            return "register";
        }
        Profile profile = new Profile();
        user.addRole(roles.findByRole("USER"));
        users.save(user);
        //user.setProfile(profile);
        profile.setProfileOwner(user);
        profile.setUsername(user.getUsername());
        profileRepository.save(profile);
        return "redirect:/";
    }
}
