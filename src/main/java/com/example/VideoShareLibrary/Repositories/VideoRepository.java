package com.example.VideoShareLibrary.Repositories;

import com.example.VideoShareLibrary.Entities.Video;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public interface VideoRepository extends CrudRepository<Video, Long> {


    @Query(value = "select  * from video where url=?1",nativeQuery = true)
    Video findByVideoUrl(@Param("url") String url);

    @Query(value = "select * from  video where id = ?1", nativeQuery = true)
    Video findByVideoId(@Param("id") long id);

}
