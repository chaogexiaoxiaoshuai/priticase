package com.example.a99544.uidemo.gson;

/**
 * Created by 99544 on 2017/10/23.
 */

public class Theme {
    private int id;
    private String name;
    private String simpleName;

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

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    @Override
    public String toString() {
        return "Theme [id=" + id + ", name=" + name + ", simpleName=" + simpleName + "]";
    }
}
