package com.example.VideoShareLibrary.Repositories;

import com.example.VideoShareLibrary.Entities.LikeDislike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeDislikeRepository extends CrudRepository<LikeDislike, Long> {


    @Query(value = "select * from like_dislike where user_id= ?1 and video_id = ?2", nativeQuery = true)
    Optional<LikeDislike> findByUserIdAndVideoId(@Param("uid") long uid, @Param("vid") long vid);


    @Query(value = "select * from like_dislike where   video_id = ?1", nativeQuery = true)
    List<LikeDislike>  findByVideoId(@Param("videoId") long videoId);



}
