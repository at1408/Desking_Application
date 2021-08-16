package com.team17.desking.entity;

import javax.persistence.*;

@Entity(name="seat")
public class Seat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long seatId;
    @Column
    private boolean blocked, booked;
    @Column
    private int floorNo;
    @Column
    private long buildingId;


    public Seat(boolean blocked, boolean booked, int floorNo, long buildingId) {
        this.blocked = blocked;
        this.booked = booked;
        this.floorNo = floorNo;
        this.buildingId = buildingId;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(long buildingId) {
        this.buildingId = buildingId;
    }


    
    public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}



    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public int getFloor() {
        return floorNo;
    }

    public void setFloor(int floorNo) {
        this.floorNo = floorNo;
    }

	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", blocked=" + blocked + ", booked=" + booked + ", floorNo=" + floorNo
				+ ", buildingId=" + buildingId + "]";
	}
    
    
}
