package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Nation implements Serializable{
    private String nationId;
    private String nationName;

    public String getNationId() {
        return nationId;
    }

    public void setNationId(String nationId) {
        this.nationId = nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
