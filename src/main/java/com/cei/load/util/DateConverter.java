package com.cei.load.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Strings;

/**
 * The Class DateConverter.
 */
@Component
public class DateConverter {
  
  /** The Constant sdf. */
  private static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd/yyyy"));
  
  /** The Constant datehrmin. */
  private static final ThreadLocal<SimpleDateFormat> datehrmin = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd/yyyy HH:mm"));
  
  /** The Constant hrmin. */
  private static final ThreadLocal<SimpleDateFormat> hrmin = ThreadLocal.withInitial(() -> new SimpleDateFormat("HH:mm:ss"));
  
  /**
   * The Class DateSerialize.
   */
  public static class DateSerialize extends JsonSerializer<Date> {
    
    /**
     * Serialize.
     *
     * @param value the value
     * @param jgen the jgen
     * @param provider the provider
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JsonProcessingException the json processing exception
     */
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value == null) {
        jgen.writeNull();
      } else {
        jgen.writeString(((SimpleDateFormat)DateConverter.sdf.get()).format(value));
      } 
    }
  }
  
  /**
   * The Class DateTimeSerialize.
   */
  public static class DateTimeSerialize extends JsonSerializer<Date> {
    
    /**
     * Serialize.
     *
     * @param value the value
     * @param jgen the jgen
     * @param provider the provider
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JsonProcessingException the json processing exception
     */
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value == null) {
        jgen.writeNull();
      } else {
        jgen.writeString(((SimpleDateFormat)DateConverter.hrmin.get()).format(value));
      } 
    }
  }
  
  /**
   * The Class DateDeserialize.
   */
  public static class DateDeserialize extends JsonDeserializer<Date> {
    
    /**
     * Deserialize.
     *
     * @param jp the jp
     * @param ctxt the ctxt
     * @return the date
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JsonProcessingException the json processing exception
     */
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      String dateAsString = jp.getText();
      try {
        if (Strings.isNullOrEmpty(dateAsString))
          return null; 
        return new Date(((SimpleDateFormat)DateConverter.sdf.get()).parse(dateAsString).getTime());
      } catch (ParseException pe) {
        throw new RuntimeException(pe);
      } 
    }
  }
  
  /**
   * The Class DateTimeDeserialize.
   */
  public static class DateTimeDeserialize extends JsonDeserializer<Date> {
    
    /**
     * Deserialize.
     *
     * @param jp the jp
     * @param ctxt the ctxt
     * @return the date
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws JsonProcessingException the json processing exception
     */
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      String dateAsString = jp.getText();
      try {
        if (Strings.isNullOrEmpty(dateAsString))
          return null; 
        return new Date(((SimpleDateFormat)DateConverter.hrmin.get()).parse(dateAsString).getTime());
      } catch (ParseException pe) {
        throw new RuntimeException(pe);
      } 
    }
  }
}
