package com.example.a99544.uidemo.model;

/**
 * Created by 99544 on 2017/5/8/008.
 */

public class Spot extends City {

    private String description;

    public Spot(String name, int imageId, String description) {
        super(name, imageId);
        this.description=description;
    }
    public String getDescription(){return description;
    }
}
