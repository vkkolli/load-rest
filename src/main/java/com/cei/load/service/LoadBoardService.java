package com.cei.load.service;

import java.util.List;

import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.SearchCriteriaDTO;

/**
 * The Interface LoadBoardService.
 */
public interface LoadBoardService {

  /**
   * Find all loads for load board.
   *
   * @return the list
   */
  public List<LoadBoardDTO> findAllLoadsForLoadBoard(String pageNumber, String recordsPerPage) ;

  public List<LoadBoardDTO> findLoadsByCriteria(SearchCriteriaDTO criteriaDTO);




}
