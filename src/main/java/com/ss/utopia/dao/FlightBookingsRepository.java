package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.entity.FlightBookings;

public interface FlightBookingsRepository extends JpaRepository<FlightBookings, Integer> {

}
