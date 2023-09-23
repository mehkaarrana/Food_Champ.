package com.ranag.myapplication;

import java.util.ArrayList;

public class Mdclass {
    int imageid;
    String name,time,title,hindiname,hindititle,link;
    String[] arr;
    String[] hindiarr;
    String[] hmarr;
    String[] hindihmarr;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Mdclass(int imageid,String link, String name,String hindiname,String time,String title,String hindititle,String[] arr,String[] hindiarr,String[] hmarr,String[] hindihmarr) {
        this.imageid = imageid;
        this.name = name;
        this.time = time;
        this.title=title;
        this.hindititle=hindititle;
        this.arr=arr;
        this.hindiname=hindiname;
        this.hindiarr=hindiarr;
        this.hmarr=hmarr;
        this.hindihmarr=hindihmarr;
        this.link=link;

    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String[] getHmarr() {
        return hmarr;
    }

    public void setHmarr(String[] hmarr) {
        this.hmarr = hmarr;
    }

    public String[] getHindihmarr() {
        return hindihmarr;
    }

    public void setHindihmarr(String[] hindihmarr) {
        this.hindihmarr = hindihmarr;
    }

    public String getHindititle() {
        return hindititle;
    }

    public void setHindititle(String hindititle) {
        this.hindititle = hindititle;
    }

    public String getHindiname() {
        return hindiname;
    }

    public void setHindiname(String hindiname) {
        this.hindiname = hindiname;
    }

    public String[] getHindiarr() {
        return hindiarr;
    }

    public void setHindiarr(String[] hindiarr) {
        this.hindiarr = hindiarr;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
