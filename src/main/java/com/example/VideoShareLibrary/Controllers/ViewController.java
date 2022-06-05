package com.example.VideoShareLibrary.Controllers;



import com.example.VideoShareLibrary.Entities.Video;
import com.example.VideoShareLibrary.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;
import java.util.List;


@Controller
public class ViewController {

    @Autowired
    private VideoService videoService;

//    signup page route
    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }


//    index page route
    @GetMapping("")
    public String getIndexPage(Model model, Principal principal){
        if(principal != null ){
            model.addAttribute("auth", "Auth User");
        }else model.addAttribute("auth", "Guest User");
        List<Video> allVideo = videoService.getAllVideo();
        model.addAttribute("allVideo", allVideo );
        return "index";
    }



}
