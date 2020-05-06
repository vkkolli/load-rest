package com.cei.load.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cei.load.domain.LoadBoard;

/**
 * The Interface LoadBoardRepository.
 */
@Repository
public interface LoadBoardRepository extends JpaRepository<LoadBoard, Long>, LoadBoardSearchRepository {

}
