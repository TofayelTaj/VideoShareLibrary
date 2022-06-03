package com.example.VideoShareLibrary.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }




}
