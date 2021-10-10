package com.navikas.Controllers;

import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.LocalizedObjectAnnotation;
import com.navikas.Entities.Picture;
import com.navikas.Model.PictureService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.vision.CloudVisionTemplate;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/pictures")
public class VisionController {

    PictureService pictureService;
    List<Picture> pictures;

    @Autowired
    private CloudVisionTemplate cloudVisionTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    public VisionController(PictureService pictureService) {
        this.pictureService = pictureService;
        pictures = pictureService.getPictures();
    }


    @GetMapping()
    public List<Picture> pictureList() {
        pictures = pictureService.getPictures();    // Get 5 latest queries

        return pictures;

    }
    @PostMapping("objects")
    public List<String> getObjects (@RequestBody Map<String, Object> url){
        String url_ = (String)url.get("url");

        // Using Google Vision, get objects from the image url, and add them to a List of Strings
        Resource imageResource = this.resourceLoader.getResource(url_);
        AnnotateImageResponse response =
                this.cloudVisionTemplate.analyzeImage(
                        imageResource, Feature.Type.OBJECT_LOCALIZATION);
        List<LocalizedObjectAnnotation> annotations = response.getLocalizedObjectAnnotationsList();
        List<String> objects = new ArrayList<String>();
        for (LocalizedObjectAnnotation element : annotations) {
            objects.add(element.getName());
        }
        pictureService.savePicture(url_, objects); // Save picture and its objects to the database

        return objects;
    }

}
