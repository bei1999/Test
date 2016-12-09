package com.bei.test.bean;

/**
 * Created by lzb on 16/12/9.
 */

public class NewsData {
    private int id;
    private String name;

    public NewsData(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
