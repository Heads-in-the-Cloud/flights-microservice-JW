package com.ss.utopia.dao;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ss.utopia.entity.AirplaneType;

public interface AirplaneTypeRepository extends JpaRepository<AirplaneType, Integer> {
	@Query(value = "select * from airplane_type a where a.id = ?1", nativeQuery = true)
	public Collection<AirplaneType> findATypeByATypeId(int id);
}
