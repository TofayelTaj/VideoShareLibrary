package com.example.VideoShareLibrary.Services;

import com.example.VideoShareLibrary.Entities.LikeDislike;
import com.example.VideoShareLibrary.Entities.User;
import com.example.VideoShareLibrary.Entities.Video;
import com.example.VideoShareLibrary.Enums.LikeDislikeEnum;
import com.example.VideoShareLibrary.Repositories.LikeDislikeRepository;
import com.example.VideoShareLibrary.Repositories.UserRepository;
import com.example.VideoShareLibrary.Repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.Principal;
import java.util.List;

@Service
public class LikeDislikeService {

    @Autowired
    private LikeDislikeRepository likeDislikeRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserRepository userRepository;


    public void doLikeOrDisLikeService(String lod, long vid, Principal principal){

        String authUser = principal.getName();
        User user = userRepository.findByUserName(authUser);
        Video  video = videoRepository.findById(vid).get();
        LikeDislike likeDislike = new LikeDislike();

        if(likeDislikeRepository.findByUserIdAndVideoId(user.getId(), video.getId()).isPresent()){
            likeDislike = likeDislikeRepository.findByUserIdAndVideoId(user.getId(), video.getId()).get();
            likeDislike.setLikeDislikeEnum(lod.equals(LikeDislikeEnum.LIKE.toString()) ? LikeDislikeEnum.LIKE : LikeDislikeEnum.DISLIKE);
        }else{
            likeDislike.setLikeDislikeEnum(lod.equals(LikeDislikeEnum.LIKE.toString()) ? LikeDislikeEnum.LIKE : LikeDislikeEnum.DISLIKE);
            likeDislike.setVideo(video);
            likeDislike.setUser(user);
        }
        likeDislikeRepository.save(likeDislike);
    }

    public List<LikeDislike> getVideoLikeDislikeDetails(long videoId){
        return likeDislikeRepository.findByVideoId(videoId);
    }

    public long getTotalLikeByVideoId(long id){

        List<LikeDislike> all  = likeDislikeRepository.findByVideoId(id);
        long count = 0;
        for(int i = 0; i<all.size(); i++){
            if(all.get(i).getLikeDislikeEnum().name().equals(LikeDislikeEnum.LIKE.toString())){
               count++;
            }
        }
        return  count;

    }

    public long getTotalDislikeByVideoId(long id) {
        List<LikeDislike> all = likeDislikeRepository.findByVideoId(id);
        long count = 0;
        for (int i = 0; i < all.size(); i++) {
            if (all.get(i).getLikeDislikeEnum().name().equalsIgnoreCase(LikeDislikeEnum.DISLIKE.toString())) {
                count++;
            }

        }
        return count;
    }

}
