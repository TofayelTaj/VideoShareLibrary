package com.example.VideoShareLibrary.Controllers;


import com.example.VideoShareLibrary.Services.LikeDislikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/v")
public class LikeDislikeController {


    @Autowired
    private LikeDislikeService likeDislikeService;

   @GetMapping("/ld")
    public String doLikeDislikeOperation(
           @RequestParam("like") String like,
           @RequestParam("vid") long vid,
           Principal principal,
           HttpServletRequest request)
   {
      likeDislikeService.doLikeOrDisLikeService(like, vid, principal);
      return "redirect:" + request.getHeader("Referer");
    }


}
