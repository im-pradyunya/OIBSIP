package com.pradyunya.resolver;

public class Item {
    String title,desc,time,date;

    public Item(String title, String desc, String date,String time) {
        this.title = title;
        this.desc = desc;
        this.time = time;
        this.date=date;
    }

    public Item() {

    }



    public String getTitle() {
        return title;
    }
    public String getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public String getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
