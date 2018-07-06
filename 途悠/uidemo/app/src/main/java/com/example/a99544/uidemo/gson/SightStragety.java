package com.example.a99544.uidemo.gson;

import java.util.List;

/**
 * Created by 99544 on 2017/10/23.
 */

public class SightStragety {
    private int id;
    private String dayToPlay;
    private String pic;
    private String name;
    private String address;
    private String ticketPrice;
    private List<String> labels;
    private String mark;
    private String phone;
    private String province;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayToPlay() {
        return dayToPlay;
    }

    public void setDayToPlay(String dayToPlay) {
        this.dayToPlay = dayToPlay;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SightStrategy [dayToPlay=" + dayToPlay + ", pic=" + pic + ", name=" + name + ", address=" + address
                + ", ticketPrice=" + ticketPrice + ", labels=" + labels + ", mark=" + mark + "]";
    }
}
