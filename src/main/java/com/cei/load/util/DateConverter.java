package com.cei.load.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Strings;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DateConverter {
  private static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd/yyyy"));
  
  private static final ThreadLocal<SimpleDateFormat> datehrmin = ThreadLocal.withInitial(() -> new SimpleDateFormat("MM/dd/yyyy HH:mm"));
  
  public static class DateSerialize extends JsonSerializer<Date> {
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value == null) {
        jgen.writeNull();
      } else {
        jgen.writeString(((SimpleDateFormat)DateConverter.sdf.get()).format(value));
      } 
    }
  }
  
  public static class DateTimeSerialize extends JsonSerializer<Date> {
    public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
      if (value == null) {
        jgen.writeNull();
      } else {
        jgen.writeString(((SimpleDateFormat)DateConverter.datehrmin.get()).format(value));
      } 
    }
  }
  
  public static class DateDeserialize extends JsonDeserializer<Date> {
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
  
  public static class DateTimeDeserialize extends JsonDeserializer<Date> {
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
      String dateAsString = jp.getText();
      try {
        if (Strings.isNullOrEmpty(dateAsString))
          return null; 
        return new Date(((SimpleDateFormat)DateConverter.datehrmin.get()).parse(dateAsString).getTime());
      } catch (ParseException pe) {
        throw new RuntimeException(pe);
      } 
    }
  }
}
