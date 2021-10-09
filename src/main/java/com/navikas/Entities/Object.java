package com.navikas.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String objectName;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    public Object(String objectName, Picture picture) {
        this.objectName = objectName;
        this.picture = picture;
    }
    public Object(){

    }
    /*
    public long getId() {
        return id;
    }
     */

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    @JsonBackReference
    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
