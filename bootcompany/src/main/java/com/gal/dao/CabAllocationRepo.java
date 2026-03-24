package com.gal.dao;

import com.gal.model.CabAllocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CabAllocationRepo extends JpaRepository<CabAllocation, Integer> {

    List<CabAllocation> findByCab_CabidAndBookingDate(int cabid, Date date);

}