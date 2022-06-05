package com.example.VideoShareLibrary.Controllers;

import com.example.VideoShareLibrary.Entities.LikeDislike;
import com.example.VideoShareLibrary.Entities.Video;
import com.example.VideoShareLibrary.Enums.LikeDislikeEnum;
import com.example.VideoShareLibrary.Services.LikeDislikeService;
import com.example.VideoShareLibrary.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/v")
public class VideoController {

    @Autowired
    private VideoService videoService;
    @Autowired
    private LikeDislikeService likeDislikeService;

    @PostMapping("/add")
    public String addVideo(@ModelAttribute Video video){
        video.setUrl(videoService.videoUrlFilter(video.getUrl()));
        videoService.saveVideo(video);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/play/{url}")
    public String playVideo(@ModelAttribute Video video, Model model){
        video = videoService.getVideoByUrl(video.getUrl());
        model.addAttribute("video", video);
        return "videoPlayer";
    }

    @GetMapping("/details")
    public String videoDetails(@RequestParam("videoId")  String videoId, HttpServletRequest request, Model model){
       List<LikeDislike> allLikeDislike = likeDislikeService.getVideoLikeDislikeDetails(Long.parseLong(videoId));
        List<LikeDislike> allLike = new ArrayList<>();
        List<LikeDislike> allDislike = new ArrayList<>();
        for(LikeDislike ld : allLikeDislike){
            if(ld.getLikeDislikeEnum().name().equalsIgnoreCase(LikeDislikeEnum.LIKE.name())){
                allLike.add(ld);
            }else{
                allDislike.add(ld);
            }
        }
        Video video = videoService.getVideoById(Long.parseLong(videoId));
        model.addAttribute("video", video);
        model.addAttribute("allLike", allLike);
        model.addAttribute("allDislike", allDislike);
//        return "redirect:" + request.getHeader("Referer");
        return "details";
    }

}
