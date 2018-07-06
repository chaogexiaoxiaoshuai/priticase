package com.example.a99544.uidemo.gson;

/**
 * Created by 99544 on 2017/10/23.
 */

public class Sight {
    private int id;
    private String city;
    private String name;
    private String pic;
    private String dayToPlay;
    private String peopleType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDayToPlay() {
        return dayToPlay;
    }

    public void setDayToPlay(String dayToPlay) {
        this.dayToPlay = dayToPlay;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    @Override
    public String toString() {
        return "Sights [id=" + id + ", city=" + city + ", name=" + name + ", pic=" + pic + ", dayToPlay=" + dayToPlay
                + ", peopleType=" + peopleType + "]";
    }
}
