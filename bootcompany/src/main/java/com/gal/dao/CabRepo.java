package com.gal.dao;

import com.gal.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepo extends JpaRepository<Cab, Integer> {
}