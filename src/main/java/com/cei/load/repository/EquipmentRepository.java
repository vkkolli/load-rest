package com.cei.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cei.load.domain.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
	
	/**
	 * Gets the all active equipment.
	 *
	 * @return the all active equipment
	 */
	@Query("select distinct e from Equipment e where e.isActive=true")
	List<Equipment> getAllActiveEquipment();
}
