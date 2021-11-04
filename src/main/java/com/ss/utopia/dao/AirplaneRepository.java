package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ss.utopia.entity.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Integer>{
}
