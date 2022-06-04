//package com.example.VideoShareLibrary.Entities;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class DisLike {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private long id;
//    private Video video;
//    private User user;
//    private boolean isDisLike;
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
//    public boolean isDisLike() {
//        return isDisLike;
//    }
//
//    public void setDisLike(boolean disLike) {
//        isDisLike = disLike;
//    }
//
//    @Override
//    public String toString() {
//        return "DisLike{" +
//                "id=" + id +
//                ", video=" + video +
//                ", user=" + user +
//                ", isDisLike=" + isDisLike +
//                '}';
//    }
//}
