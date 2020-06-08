package com.cei.load.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteriaDTO {
    private Long loadId;
    private Long customerId;
    private Long equipmentId;
    private String originCsz;
    private String destinationCsz;
    private String sortOrder;
    private Integer pageNumber;
    private Integer pageResultsCount;
}
