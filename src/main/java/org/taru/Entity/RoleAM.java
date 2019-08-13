package org.taru.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleAM {
    private String id;
    private  String name;
    private String description;
    private List<PrivilegeAM> privilegeAMS;

    @Override
    public String toString() {
        return "RoleAM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", privileges=" + privileges +
                '}';
    }

    //记住所有的权限
    private Set<PrivilegeAM> privileges =new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<PrivilegeAM> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<PrivilegeAM> privileges) {
        this.privileges = privileges;
    }

    public List<PrivilegeAM> getPrivilegeAMS() {
        return privilegeAMS;
    }

    public void setPrivilegeAMS(List<PrivilegeAM> privilegeAMS) {
        this.privilegeAMS = privilegeAMS;
    }
}
