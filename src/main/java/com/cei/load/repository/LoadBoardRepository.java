package com.cei.load.repository;

import java.util.List;

import com.cei.load.domain.Load;
import com.cei.load.domain.LoadBoard;
import com.cei.load.model.LoadBoardDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * The Interface LoadBoardRepository.
 */
@Repository
public interface LoadBoardRepository extends JpaRepository<LoadBoard, Long> {


  @Query(name = LoadBoard.GET_ALL_LOADS_FOR_LOAD_BOARD, nativeQuery = true)
  List<LoadBoardDTO> findAllLoadBoardMapping();

}
