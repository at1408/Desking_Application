package com.team17.desking.entity;

import javax.persistence.*;

@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column
    private long  teamId;
    @Column
    private String fName;
    @Column
    private String lName;
    @Column
    private String role;
    @Column
    private String email;

    public User() {
    }

    public User(long teamId, String fName, String lName, String role,String email) {
        this.teamId = teamId;
        this.fName = fName;
        this.lName = lName;
        this.role = role;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", teamId=" + teamId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
