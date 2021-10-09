package com.navikas.Model;

import com.navikas.Entities.Object;
import com.navikas.Entities.Picture;

import java.util.List;

public interface PictureService {
    void savePicture(String url, List<String> stringObjects);
    List <Picture> getPictures();
}
