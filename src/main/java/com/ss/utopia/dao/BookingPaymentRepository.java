package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.entity.BookingPayment;
public interface BookingPaymentRepository extends JpaRepository<BookingPayment, Integer> {

}
