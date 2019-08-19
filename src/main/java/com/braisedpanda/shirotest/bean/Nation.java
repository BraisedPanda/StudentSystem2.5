package com.braisedpanda.shirotest.bean;

import java.io.Serializable;

public class Nation implements Serializable{
    private String nationId;
    private String nationName;

    public String getnationId() {
        return nationId;
    }

    public void setnationId(String nationId) {
        this.nationId = nationId;
    }

    public String getnationName() {
        return nationName;
    }

    public void setnationName(String nationName) {
        this.nationName = nationName;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "nationId='" + nationId + '\'' +
                ", nationName='" + nationName + '\'' +
                '}';
    }
}
