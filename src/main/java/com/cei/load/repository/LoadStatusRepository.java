package com.cei.load.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.LoadStatus;

/**
 * The Interface LoadStatusRepository.
 */
@Repository
public interface LoadStatusRepository extends JpaRepository<LoadStatus, Long> {
	
	/**
	 * Find all active load status.
	 *
	 * @return the list
	 */
	@Query("select ls from LoadStatus ls where ls.isActive = true")
	List<LoadStatus> findAllActiveLoadStatus();
}
