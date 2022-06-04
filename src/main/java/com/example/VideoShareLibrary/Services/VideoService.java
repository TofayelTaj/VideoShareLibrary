package com.example.VideoShareLibrary.Services;

import com.example.VideoShareLibrary.Entities.Video;
import com.example.VideoShareLibrary.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

//    get all videos
    public List<Video> getAllVideo(){
        List<Video> allVideo = new ArrayList<>();
        allVideo = (List<Video>) videoRepository.findAll();
        return allVideo;
    }

//  Save the video
    public void saveVideo(Video video){
        videoRepository.save(video);
    }

    public String videoUrlFilter(String url){
        return url.split("/")[3];
    }



}
