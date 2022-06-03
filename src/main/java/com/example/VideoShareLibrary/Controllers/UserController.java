package com.example.VideoShareLibrary.Controllers;

import com.example.VideoShareLibrary.Entities.User;
import com.example.VideoShareLibrary.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/reg")
    public String doUserRegistration( @ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user);
        userRepository.save(user);
        return "redirect:/";
    }


}
