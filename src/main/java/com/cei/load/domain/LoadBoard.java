package com.cei.load.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
                @ColumnResult(name = "equipmentDesc", type = String.class),
                @ColumnResult(name = "equipmentLength", type = String.class),
                @ColumnResult(name = "equipmentWeight", type = String.class),
                @ColumnResult(name = "loadType", type = String.class),
                @ColumnResult(name = "loadStatus", type = String.class),
                @ColumnResult(name = "customerName", type = String.class),
                @ColumnResult(name = "customerEmail", type = String.class),
                @ColumnResult(name = "customerPhone", type = String.class),
                @ColumnResult(name = "customerAddress", type = String.class),
                @ColumnResult(name = "mileage", type = BigDecimal.class),
                @ColumnResult(name = "originCsz", type = String.class),
                @ColumnResult(name = "pickupDate", type = String.class),
                @ColumnResult(name = "destinationCsz", type = String.class),
                @ColumnResult(name = "deliveryDate", type = String.class),
                @ColumnResult(name = "commodityName", type = String.class),
                @ColumnResult(name = "commodityWeight", type = String.class),
                @ColumnResult(name = "commodityLength", type = String.class),
                @ColumnResult(name = "commodityValue", type = BigDecimal.class),
                @ColumnResult(name = "revenueCost", type = String.class),
                @ColumnResult(name = "carrierName", type = String.class),
                @ColumnResult(name = "carrierContact", type = String.class),
                @ColumnResult(name = "carrierEmail", type = String.class),
                @ColumnResult(name = "carrierPhone", type = String.class),
                @ColumnResult(name = "carrierAddress", type = String.class),
                @ColumnResult(name = "actualPickupDate", type = String.class),
                @ColumnResult(name = "actualDeliveryDate", type = String.class)
        }))

@NamedNativeQueries({
        @NamedNativeQuery(name = "LoadBoard.getAllLoadsForLoadBoard", query = LoadBoard.LOAD_BOARD_QUERY,
                resultSetMapping = "LoadBoard.getAllLoadsForLoadBoardMapping")})
public class LoadBoard {


  /** The load id. */
  @Id
  @Column(name = "load_id", unique = true, nullable = false)
  private long loadId;

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 3559760362661796004L;

  /** The Constant FIND_ALL_LOAD_BOARD. */
  public static final String GET_ALL_LOADS_FOR_LOAD_BOARD = "LoadBoard.getAllLoadsForLoadBoard";

  /** The Constant LOAD_BOARD_QUERY. */
  public static final String LOAD_BOARD_QUERY = "SELECT l.load_id as loadId\n" +
          "     , to_char(age(current_date, l.created_date), 'DD \"Days\" HH24 \":\" MI ') as age\n" +
          "     , e.equipment_name as equipmentName\n" +
          "     , e.equipment_description as equipmentDesc\n" +
          "     , e.equipment_length as equipmentLength\n" +
          "     , e.equipment_weight as equipmentWeight\n" +
          "     , l.load_size as loadType\n" +
          "     , ls.load_status_name as loadStatus\n" +
          "     , c.company as customerName\n" +
          "     , a.email_id as customerEmail\n" +
          "     , a.phone_no as customerPhone\n" +
          "     , concat( a.city , ' ', a.state_abbr, ' ', a.zipcode) as customerAddress\n" +
          "     , l.trip_mileage as mileage\n" +
          "     , concat( ltd_o.city , ' ', ltd_o.state_abbr, ' ', ltd_o.zip_code) as originCsz\n" +
          "     , concat( ltd_o.expected_trip_date, ' ', ltd_o.expected_trip_time) as pickupDate\n" +
          "     , concat( ltd_d.city , ' ', ltd_d.state_abbr, ' ', ltd_d.zip_code) as destinationCsz\n" +
          "     , concat( ltd_d.expected_trip_date, ' ', ltd_d.expected_trip_time) as deliveryDate\n" +
          "     , (ltd_d.expected_trip_date + ltd_d.expected_trip_time) as deliveryDate_tmsp\n" +
          "     , lc.commodity_name as commodityName\n" +
          "     , lc.commodity_weight as commodityWeight\n" +
          "     , lc.commodity_length as commodityLength\n" +
          "     , lc.commodity_value as commodityValue\n" +
          "     , total_revenue as revenueCost\n" +
          "     , ca.carrier_name as carrierName\n" +
          "     , ca.carrier_contact as carrierContact\n" +
          "     , ca.email_id as carrierEmail\n" +
          "     , ca.phone as carrierPhone\n" +
          "     , concat( ca.city , ' ', ca.state_abbr, ' ', ca.zip) as carrierAddress\n" +
          "     , concat( ltd_o.actual_trip_date, ' ', ltd_o.actual_trip_time) as actualPickupDate\n" +
          "     , concat( ltd_d.actual_trip_date, ' ', ltd_d.actual_trip_time) as actualDeliveryDate\n" +
          "     , ( ltd_d.actual_trip_date + ltd_d.actual_trip_time) as actualDeliveryDate_tmsp\n" +
          "  FROM logisol.load l\n" +
          "INNER JOIN logisol.customer c ON \n" +
          "    (c.customer_id = l.customer_id)\n" +
          "INNER JOIN logisol.addresses a  ON \n" +
          "    (a.customer_id = c.customer_id\n" +
          "     AND a.address_id = l.customer_address_id)\n" +
          "INNER JOIN logisol.equipment e ON \n" +
          "    (e.equipment_id = l.equipment_id)\n" +
          "INNER JOIN logisol.load_status ls ON \n" +
          "    ( ls.load_status_id = l.load_status_id)\n" +
          "LEFT OUTER JOIN logisol.carrier ca ON \n" +
          "    ( ca.carrier_id = l.carrier_id) \n" +
          "left outer join (select * from logisol.load_trip_details ltd \n" +
          "                  where  (ltd.trip_type) = 'ORGIN') ltd_o on \n" +
          "    (l.load_id = ltd_o.load_id)\n" +
          "left outer join (select * from logisol.load_trip_details ltd \n" +
          "                  where  (ltd.trip_type) = 'DESTINATION') ltd_d on \n" +
          "    (l.load_id = ltd_d.load_id) \n" +
          "left outer join logisol.load_commodity lc on\n" +
          "    (l.load_id = lc.load_id) order by l.load_id desc;";

}