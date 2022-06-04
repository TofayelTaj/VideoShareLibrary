//package com.example.VideoShareLibrary.Entities;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Like {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private long id;
//    private Video video;
//    private User user;
//    private boolean isLike;
//
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public Video getVideo() {
//        return video;
//    }
//
//    public void setVideo(Video video) {
//        this.video = video;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public boolean isLike() {
//        return isLike;
//    }
//
//    public void setLike(boolean like) {
//        isLike = like;
//    }
//
//    @Override
//    public String toString() {
//        return "Like{" +
//                "id=" + id +
//                ", video=" + video +
//                ", user=" + user +
//                ", isLike=" + isLike +
//                '}';
//    }
//}
