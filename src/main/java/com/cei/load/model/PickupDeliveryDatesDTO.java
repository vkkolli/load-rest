package com.cei.load.model;

import com.cei.load.util.DateConverter;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreType
public class PickupDeliveryDatesDTO {
    private Long loadId;
    private String tripType;
    private String pickupOrDeliveryDate;
    private String pickupOrDeliveryTime;
}
