package com.team17.desking.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity(name="team")
public class Team {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long teamId;
    @Column
    private String teamName;
    @Column
    private String division;

    public Team() {
    }

    public Team(String teamName, String division) {
        this.teamName = teamName;
        this.division = division;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", division='" + division + '\'' +
                '}';
    }
}
