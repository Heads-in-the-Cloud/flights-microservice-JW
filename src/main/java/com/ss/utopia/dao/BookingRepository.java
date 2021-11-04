package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking,Integer>{

}
