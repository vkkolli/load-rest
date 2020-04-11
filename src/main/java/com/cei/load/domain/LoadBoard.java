package com.cei.load.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
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
    columns = {@ColumnResult(name = "loadId", type = Long.class),
        @ColumnResult(name = "age", type = String.class),
        @ColumnResult(name = "equipmentName", type = String.class),
        @ColumnResult(name = "loadType", type = String.class),
        @ColumnResult(name = "loadStatus", type = String.class),
        @ColumnResult(name = "customerName", type = String.class),
        @ColumnResult(name = "customerEmail", type = String.class),
        @ColumnResult(name = "mileage", type = BigDecimal.class),
        @ColumnResult(name = "originCsz", type = String.class),
        @ColumnResult(name = "pickupDate", type = String.class),
        @ColumnResult(name = "destinationCsz", type = String.class),
        @ColumnResult(name = "deliveryDate", type = String.class),
        @ColumnResult(name = "commodityName", type = String.class),
        @ColumnResult(name = "commodityWeight", type = String.class),
        @ColumnResult(name = "commodityLength", type = String.class),
        @ColumnResult(name = "revenueCost", type = String.class),
        @ColumnResult(name = "carrierName", type = String.class),
        @ColumnResult(name = "actualPickupDate", type = String.class),
        @ColumnResult(name = "actualDeliveryDate", type = String.class)
    }))

@NamedNativeQueries({
    @NamedNativeQuery(name = "LoadBoard.getAllLoadsForLoadBoard", query = LoadBoard.LOAD_BOARD_QUERY,
        resultSetMapping = "LoadBoard.getAllLoadsForLoadBoardMapping")})
public class LoadBoard {


  @Id
  @Column(name = "load_id", unique = true, nullable = false)
  private long loadId;

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 3559760362661796004L;

  /** The Constant FIND_ALL_LOAD_BOARD. */
  public static final String GET_ALL_LOADS_FOR_LOAD_BOARD = "LoadBoard.getAllLoadsForLoadBoard";

  /** The Constant LOAD_BOARD_QUERY. */
  public static final String LOAD_BOARD_QUERY = "SELECT \tl.load_id as loadId, \n" +
          "\t\tto_char(now() - l.created_date, 'DD\" day(s) \"HH24\" hours \"MI\" mins') as age,\n" +
          "\t\te.equipment_name as equipmentName,\n" +
          "\t\tload_size as loadType, \n" +
          "\t\tls.load_status_name as loadStatus,\n" +
          "\t\tcu.company as customerName,\n" +
          "\t\tcu.customer_email as customerEmail,\n" +
          "\t\ttrip_mileage as mileage,\n" +
          "\t\t(select concat( ltd.city , ', ', ltd.state_abbr, ', ', ltd.zip_code) from logisol.load_trip_details ltd where ltd.trip_type = 'ORGIN' and ltd.load_id = l.load_id ) as  originCsz, \n" +
          "\t\t(select concat( ltd.expected_trip_date, ', ', ltd.expected_trip_time) from logisol.load_trip_details ltd where ltd.trip_type = 'ORGIN' and ltd.load_id = l.load_id ) as  pickupDate, \n" +
          "\t\t(select concat( ltd.city , ', ', ltd.state_abbr, ', ', ltd.zip_code) from logisol.load_trip_details ltd where ltd.trip_type = 'DESTINATION' and ltd.load_id = l.load_id ) as  destinationCsz, \n" +
          "\t\t(select concat( ltd.expected_trip_date, ', ', ltd.expected_trip_time) from logisol.load_trip_details ltd where ltd.trip_type = 'DESTINATION' and ltd.load_id = l.load_id ) as  deliveryDate, \n" +
          "\t\t(select lc.commodity_name from logisol.load_commodity lc where lc.load_id = l.load_id) as commodityName,\n" +
          "\t\t(select lc.commodity_weight from logisol.load_commodity lc where lc.load_id = l.load_id) as commodityWeight,\n" +
          "\t\t(select lc.commodity_length from logisol.load_commodity lc where lc.load_id = l.load_id) as commodityLength,\n" +
          "\t\ttotal_revenue as revenueCost, \n" +
          "\t\tca.carrier_name as carrierName,\t\n" +
          "\t\t(select concat( ltd.actual_trip_date, ', ', ltd.actual_trip_time) from logisol.load_trip_details ltd where ltd.trip_type = 'ORGIN' and ltd.load_id = l.load_id ) as  actualPickupDate, \n" +
          "\t\t(select concat( ltd.actual_trip_date, ', ', ltd.actual_trip_time) from logisol.load_trip_details ltd where ltd.trip_type = 'DESTINATION' and ltd.load_id = l.load_id ) as  actualDeliveryDate \n" +
          "FROM logisol.load l \n" +
          "left outer join logisol.load_status ls on (ls.load_status_id = l.load_status_id)\n" +
          "left outer join logisol.customer cu on (cu.customer_id = l.customer_id)\n" +
          "left outer join logisol.equipment e on (e.equipment_id  = l.equipment_id)\n" +
          "left outer join logisol.carrier ca on (ca.carrier_id  = l.carrier_id)\n" +
          "order by load_id desc";

}
