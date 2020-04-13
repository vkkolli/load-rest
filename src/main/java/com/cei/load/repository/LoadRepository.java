package com.cei.load.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.Load;

/**
 * The Interface LoadRepository.
 */
@Repository
public interface LoadRepository extends JpaRepository<Load, Long> {

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<Load> findAll();

}
