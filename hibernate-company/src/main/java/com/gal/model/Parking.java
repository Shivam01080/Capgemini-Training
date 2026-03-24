package com.gal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_id")
    private Integer parkingId;

    @Column(name = "floor_no")
    private int floorNo;

    @Column(name = "slot_number")
    private String slotNumber;

    public Parking() {}

    public Parking(int floorNo, String slotNumber) {
        this.floorNo = floorNo;
        this.slotNumber = slotNumber;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(String slotNumber) {
        this.slotNumber = slotNumber;
    }
}