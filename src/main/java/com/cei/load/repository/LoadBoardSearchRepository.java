package com.cei.load.repository;


import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.SearchCriteriaDTO;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * The Interface LoadBoardSearchRepository.
 */

public interface LoadBoardSearchRepository {

   List<LoadBoardDTO> findAllLoads();
   List<LoadBoardDTO> findLoadsByCriteria(SearchCriteriaDTO criteriaDTO);

}
