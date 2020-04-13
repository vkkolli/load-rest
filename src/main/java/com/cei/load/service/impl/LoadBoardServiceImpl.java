package com.cei.load.service.impl;

import java.lang.invoke.MethodHandles;
import java.util.List;
import com.cei.load.model.LoadBoardDTO;
import com.cei.load.repository.LoadBoardRepository;
import com.cei.load.service.LoadBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadBoardServiceImpl implements LoadBoardService {

  /** The Constant LOGGER. */
  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  /** The load board repository. */
  @Autowired
  private LoadBoardRepository loadBoardRepository;


  @Override
  public List<LoadBoardDTO> findAllLoadsForLoadBoard() {

    List<LoadBoardDTO> loadBoard = loadBoardRepository.findAllLoadBoardMapping();

    return loadBoard;
  }


}
