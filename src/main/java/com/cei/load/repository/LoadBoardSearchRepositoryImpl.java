package com.cei.load.repository;

import com.cei.load.model.LoadBoardDTO;
import com.cei.load.model.SearchCriteriaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * The Interface LoadBoardRepository.
 */
@Transactional
public class LoadBoardSearchRepositoryImpl implements LoadBoardSearchRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @PersistenceContext
  EntityManager entityManager;

  public static String SEARCH_STRING="";

  public List<LoadBoardDTO> findAllLoads(Integer pageNumber, Integer recordsPerPage) {
    StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("logisol.fn_get_load_board",
            "LoadBoard.getAllLoadsForLoadBoardMapping");

    procedureQuery.registerStoredProcedureParameter("p_load_id", Long.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_customer_id", Long.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_equipment_id", Long.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_origin_csz", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_destination_csz", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_pageid", Integer.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_rec_limit", Integer.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_sort_order", String.class, ParameterMode.IN);

    procedureQuery.setParameter("p_load_id", null);
    procedureQuery.setParameter("p_customer_id", null);
    procedureQuery.setParameter("p_equipment_id", null);
    procedureQuery.setParameter("p_origin_csz", null);
    procedureQuery.setParameter("p_destination_csz", null);
    procedureQuery.setParameter("p_pageid", pageNumber);
    procedureQuery.setParameter("p_rec_limit", recordsPerPage);
    procedureQuery.setParameter("p_sort_order", "load_id desc");
    List<LoadBoardDTO> loadBoardDTOList = procedureQuery.getResultList();

    return loadBoardDTOList;
  }

  @Override
  public List<LoadBoardDTO> findLoadsByCriteria(SearchCriteriaDTO criteriaDTO) {

    StoredProcedureQuery procedureQuery = entityManager.createStoredProcedureQuery("logisol.fn_get_load_board",
            "LoadBoard.getAllLoadsForLoadBoardMapping");

    procedureQuery.registerStoredProcedureParameter("p_load_id", Long.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_customer_id", Long.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_equipment_id", Long.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_origin_csz", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_destination_csz", String.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_pageid",Integer.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_rec_limit",Integer.class, ParameterMode.IN);
    procedureQuery.registerStoredProcedureParameter("p_sort_order",String.class, ParameterMode.IN);

    procedureQuery.setParameter("p_load_id", criteriaDTO.getLoadId());
    procedureQuery.setParameter("p_customer_id", criteriaDTO.getCustomerId());
    procedureQuery.setParameter("p_equipment_id", criteriaDTO.getEquipmentId());
    procedureQuery.setParameter("p_origin_csz", setNullOnEmpty(criteriaDTO.getOriginCsz()));
    procedureQuery.setParameter("p_destination_csz", setNullOnEmpty(criteriaDTO.getDestinationCsz()));
    procedureQuery.setParameter("p_pageid", criteriaDTO.getPageNumber() );
    procedureQuery.setParameter("p_rec_limit", Integer.valueOf(criteriaDTO.getPageResultsCount()));
    procedureQuery.setParameter("p_sort_order", criteriaDTO.getSortOrder());

    List<LoadBoardDTO> loadBoardDTOList = procedureQuery.getResultList();

    return loadBoardDTOList;
  }

  public static String setNullOnEmpty(final String text) {
    return text != null && text.trim().isEmpty() ? null : text;
  }


}
