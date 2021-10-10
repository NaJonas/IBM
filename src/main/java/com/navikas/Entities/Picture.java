package com.navikas.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/*
    Picture Entity class
    Unique auto incremented id, a String value for image url
    Has One to Many relationship with Object entity table

 */

@Entity
public class Picture {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String url;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "picture")
    private List<Object> objects;

    public Picture(List<Object> objects, String url) {
        this.objects = objects;
        this.url = url;
    }
    public Picture(){

    }

    @JsonManagedReference
    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
