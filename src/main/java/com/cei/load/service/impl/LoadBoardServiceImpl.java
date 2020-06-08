package com.cei.load.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;
import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.SearchCriteriaDTO;
import com.cei.load.repository.LoadBoardRepository;
import com.cei.load.repository.LoadBoardSearchRepository;
import com.cei.load.service.LoadBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Class LoadBoardServiceImpl.
 */
@Service
public class LoadBoardServiceImpl implements LoadBoardService {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  /** The load board repository. */
  @Autowired
  private LoadBoardRepository loadBoardRepository;


  /**
   * Find all loads for load board.
   *
   * @return the list
   */
  @Override
  public List<LoadBoardDTO> findAllLoadsForLoadBoard() {
    return loadBoardRepository.findAllLoads();
  }

  @Override
  public List<LoadBoardDTO> findLoadsByCriteria(SearchCriteriaDTO criteriaDTO) {
    return loadBoardRepository.findLoadsByCriteria(criteriaDTO);
  }



}
