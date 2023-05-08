package com.yy.letsgetsomemuscules.Activities.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {

    String url_img;
    String type;

    public CategoryModel() {
    }

    public CategoryModel(String url_img, String type) {
        this.url_img = url_img;
        this.type = type;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
