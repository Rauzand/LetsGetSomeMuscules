package com.yy.letsgetsomemuscules.Activities.models;

import java.io.Serializable;

public class TrainingModel implements Serializable {
    String url_img;
    String description;
    String name;
    String type;

    public TrainingModel() {
    }

    public TrainingModel(String url_img, String description, String name, String type) {
        this.url_img = url_img;
        this.description = description;
        this.name = name;
        this.type = type;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
