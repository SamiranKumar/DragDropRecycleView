package com.skh.samir.dragdroprecycleview;

/**
 * Created by samir on 3/20/2017.
 */

public class ListItem {

    private int id;
    private String text;
    private int img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", img=" + img +
                '}';
    }
}
