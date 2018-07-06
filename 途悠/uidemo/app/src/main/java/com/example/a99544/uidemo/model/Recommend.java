package com.example.a99544.uidemo.model;

/**
 * Created by 99544 on 2017/5/13/013.
 */

public class Recommend {

    private String userid;

    private int userImageId;

    private int  spotImagerId;

    private String brief;

    public Recommend(String userId,int userImageId,int spotImageId,String brief){
        this.userid=userId;
        this.userImageId=userImageId;
        this.spotImagerId=spotImageId;
        this.brief=brief;
    }

    public String getBrief(){return brief;}
    public String getUserid(){
        return userid;
    }

    public int getUserImageId(){
        return userImageId;
    }

    public int getSpotImagerId(){return spotImagerId;
    }

}
