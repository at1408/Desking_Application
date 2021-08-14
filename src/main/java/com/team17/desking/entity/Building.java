package com.team17.desking.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="building")
public class Building {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int buildingId;
	
	@Column
	private String buildingName;
	
	@Column
	private int noOfFloor;

	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Building(String buildingName, int noOfFloor) {
		super();
		this.buildingName = buildingName;
		this.noOfFloor = noOfFloor;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public int getNoOfFloor() {
		return noOfFloor;
	}

	public void setNoOfFloor(int noOfFloor) {
		this.noOfFloor = noOfFloor;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", buildingname=" + buildingName + ", noOfFloor=" + noOfFloor
				+ "]";
	}

	
}
