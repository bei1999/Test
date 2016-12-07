package com.bei.test.bean;

import java.io.Serializable;

/**
 * Created by lzb on 16/12/7.
 */

public class NewsCategoryBean implements Serializable {
    private int id;
    private String name;

    public NewsCategoryBean(int id, String name) {
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
