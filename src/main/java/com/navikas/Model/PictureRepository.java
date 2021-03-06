package com.navikas.Model;

import com.navikas.Entities.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Long> {
    Picture findPictureByUrl(String url);
    List<Picture> findFirst5ByOrderByIdDesc();
}
