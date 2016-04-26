package com.example.linh.test1;

/**
 * Created by linh on 4/25/2016.
 */
public class country {
    private String name;
    private String code;
    private String img;

    public country(String name, String code, String img) {
        this.name = name;
        this.code = code;
        this.img = img;
    }

    public country() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
