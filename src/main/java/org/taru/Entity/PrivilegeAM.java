package org.taru.Entity;

import java.util.ArrayList;
import java.util.List;

public class PrivilegeAM {

    private String privId ;
    private String privName ;
    private String privLevel ;
    private String privFatherid ;
    private String privUrl ;
    private String privStaus ;
    private  String sort;

    private  List<PrivilegeAM> privilegeAMS = new ArrayList<PrivilegeAM>();
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<PrivilegeAM> getPrivilegeAMS() {
        return privilegeAMS;
    }

    public void setPrivilegeAMS(List<PrivilegeAM> privilegeAMS) {
        this.privilegeAMS = privilegeAMS;
    }

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


    public PrivilegeAM() {

    }

    @Override
    public String toString() {
        return "PrivilegeAM{" +
                "privId='" + privId + '\'' +
                ", privName='" + privName + '\'' +
                ", privLevel='" + privLevel + '\'' +
                ", privFatherid='" + privFatherid + '\'' +
                ", privUrl='" + privUrl + '\'' +
                ", privStaus='" + privStaus + '\'' +
                ", sort='" + sort + '\'' +
                ", privilegeAMS=" + privilegeAMS +
                '}';
    }

    public PrivilegeAM(String  privId, String privName, String privLevel, String privFatherid, String privUrl,
                       String privStaus) {
        super();
        this.privId = privId;
        this.privName = privName;
        this.privLevel = privLevel;
        this.privFatherid = privFatherid;
        this.privUrl = privUrl;
        this.privStaus = privStaus;
    }



}
