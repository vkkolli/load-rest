package com.cei.load.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Id;

import com.cei.load.model.LoadBoardDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class LoadBoard.
 */
@Entity
@Table(name = "load", schema = "logisol")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@SqlResultSetMapping(name = "LoadBoard.getAllLoadsForLoadBoardMapping", classes = @ConstructorResult(
        targetClass = LoadBoardDTO.class,
        columns = {@ColumnResult(name = "load_id", type = Long.class),
                @ColumnResult(name = "age_of_load", type = String.class),
                @ColumnResult(name = "equipment_name", type = String.class),
                @ColumnResult(name = "equipment_description", type = String.class),
                @ColumnResult(name = "equipment_length", type = BigDecimal.class),
                @ColumnResult(name = "equipment_weight", type = BigDecimal.class),
                @ColumnResult(name = "load_type", type = String.class),
                @ColumnResult(name = "load_status", type = String.class),
                @ColumnResult(name = "customer_name", type = String.class),
                @ColumnResult(name = "customer_email", type = String.class),
                @ColumnResult(name = "customer_phone", type = String.class),
                @ColumnResult(name = "customer_address", type = String.class),
                @ColumnResult(name = "mileage", type = BigDecimal.class),
                @ColumnResult(name = "origin_csz", type = String.class),
                @ColumnResult(name = "pickup_date", type = String.class),
                @ColumnResult(name = "destination_csz", type = String.class),
                @ColumnResult(name = "delivery_date", type = String.class),
                @ColumnResult(name = "commodity_name", type = String.class),
                @ColumnResult(name = "commodity_weight", type = String.class),
                @ColumnResult(name = "commodity_length", type = String.class),
                @ColumnResult(name = "commodity_value", type = BigDecimal.class),
                @ColumnResult(name = "revenue_cost", type = String.class),
                @ColumnResult(name = "carrier_name", type = String.class),
                @ColumnResult(name = "carrier_contact", type = String.class),
                @ColumnResult(name = "carrier_email", type = String.class),
                @ColumnResult(name = "carrier_phone", type = String.class),
                @ColumnResult(name = "carrier_address", type = String.class),
                @ColumnResult(name = "actual_pickup_date", type = String.class),
                @ColumnResult(name = "actual_delivery_date", type = String.class),
                @ColumnResult(name = "is_confirm_pickup_enable", type = Boolean.class),
                @ColumnResult(name = "is_confirm_delivery_enable", type = Boolean.class)
        }))


public class LoadBoard {


  /** The load id. */
  @Id
  @Column(name = "load_id", unique = true, nullable = false)
  private long loadId;

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 3559760362661796004L;

}