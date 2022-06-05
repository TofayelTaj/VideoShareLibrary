package com.example.VideoShareLibrary.Entities;

import com.example.VideoShareLibrary.Enums.LikeDislikeEnum;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class LikeDislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "like_dislike")
    private LikeDislikeEnum likeDislikeEnum;
    @OneToOne(cascade = CascadeType.ALL )
    private Video video;
    @OneToOne(cascade = CascadeType.ALL )
    private User user;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LikeDislikeEnum getLikeDislikeEnum() {
        return likeDislikeEnum;
    }

    public void setLikeDislikeEnum(LikeDislikeEnum likeDislikeEnum) {
        this.likeDislikeEnum = likeDislikeEnum;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LikeDislike{" +
                "id=" + id +
                ", likeDislikeEnum=" + likeDislikeEnum +
                ", video=" + video.getTitle() +
                ", user=" + user.getName() +
                '}';
    }
}
