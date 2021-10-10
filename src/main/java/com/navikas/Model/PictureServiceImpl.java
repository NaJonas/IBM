package com.navikas.Model;

import com.navikas.Entities.Object;
import com.navikas.Entities.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements PictureService{
    private PictureRepository pictureRepository;
    private ObjectRepository objectRepository;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, ObjectRepository objectRepository) {
        this.pictureRepository = pictureRepository;
        this.objectRepository = objectRepository;
    }


    // Save the picture and all the objects found within that picture
    @Override
    public void savePicture(String url, List<String> stringObjects) {
        Picture picture = new Picture();
        picture.setUrl(url);
        pictureRepository.save(picture);

        // Iterate the objects from the api, create Object and save to the database
        for (String object : stringObjects) {
            Object obj = new Object(object, picture);
            objectRepository.save(obj);
        }

    }
    @Override
    public List<Picture> getPictures(){
        // Get the last 5 queries
        List<Picture> pictureList = pictureRepository.findFirst5ByOrderByIdDesc();
        return pictureList;
    }
}
