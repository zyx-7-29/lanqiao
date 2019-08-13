package org.taru.Entity;

import java.util.List;

public class Priv {
    private String privId ;
    private String privName ;
    private String privLevel ;
    private String privFatherid ;
    private String privUrl ;
    private String privStaus ;
    private  String sort;

    public String getPrivId() {
        return privId;
    }

    public void setPrivId(String privId) {
        this.privId = privId;
    }

    public String getPrivName() {
        return privName;
    }

    public void setPrivName(String privName) {
        this.privName = privName;
    }

    public String getPrivLevel() {
        return privLevel;
    }

    public void setPrivLevel(String privLevel) {
        this.privLevel = privLevel;
    }

    public String getPrivFatherid() {
        return privFatherid;
    }

    public void setPrivFatherid(String privFatherid) {
        this.privFatherid = privFatherid;
    }

    public String getPrivUrl() {
        return privUrl;
    }

    public void setPrivUrl(String privUrl) {
        this.privUrl = privUrl;
    }

    public String getPrivStaus() {
        return privStaus;
    }

    public void setPrivStaus(String privStaus) {
        this.privStaus = privStaus;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<Priv> getPrivs() {
        return privs;
    }

    public void setPrivs(List<Priv> privs) {
        this.privs = privs;
    }

    private List<Priv> privs;
}
