package com.cei.load.repository;

import com.cei.load.domain.LoadStatus;
import com.cei.load.domain.LoadTripDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * The Interface LoadTripDetailsRepository.
 */
@Repository
public interface LoadTripDetailsRepository extends JpaRepository<LoadTripDetails, Long> {
	
	/**
	 * update actualTrip Date and Time.
	 *
	 * @return the list
	 */
	@Modifying
	@Transactional
	@Query(value = "update logisol.load_trip_details set actual_trip_date=:tripDate, actual_trip_time=:tripTime where trip_type = 'ORGIN' and load_id=:loadId", nativeQuery = true)
	int updateActualPickupDates(@Param("tripDate") Date tripDate,
                                @Param("tripTime") Date tripTime,
                                @Param("loadId") Long loadId);

	@Modifying
	@Transactional
	@Query(value = "update logisol.load_trip_details set actual_trip_date=:tripDate, actual_trip_time=:tripTime where trip_type = 'DESTINATION' and load_id=:loadId", nativeQuery = true)
	int updateActualDeliveryDates(@Param("tripDate") Date tripDate,
                                  @Param("tripTime") Date tripTime,
                                  @Param("loadId") Long loadId);


}
