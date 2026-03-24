package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cab {
@Id
private int cabid;
@Column(nullable=false,unique=true)
private String regno;
private String model;
private Integer capacity;

public int getCabid() {
	return cabid;
}
public void setCabid(int cabid) {
	this.cabid = cabid;
}
public String getRegno() {
	return regno;
}
public void setRegno(String regno) {
	this.regno = regno;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public Integer getCapacity() {
	return capacity;
}
public void setCapacity(Integer capacity) {
	this.capacity = capacity;
}
}
