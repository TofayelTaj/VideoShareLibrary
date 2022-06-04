package com.example.VideoShareLibrary.Controllers;

import com.example.VideoShareLibrary.Entities.Video;
import com.example.VideoShareLibrary.Services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/add")
    public String addVideo(@ModelAttribute Video video){
        video.setUrl(videoService.videoUrlFilter(video.getUrl()));
        videoService.saveVideo(video);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/play/{url}")
    public String playVideo(@ModelAttribute Video video, Model model){
        model.addAttribute("videoUrl", video.getUrl());
        return "videoPlayer";
    }

}
