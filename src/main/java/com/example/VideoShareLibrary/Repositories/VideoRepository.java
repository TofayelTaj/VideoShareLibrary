package com.example.VideoShareLibrary.Repositories;

import com.example.VideoShareLibrary.Entities.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface VideoRepository extends CrudRepository<Video, Long> {
}
