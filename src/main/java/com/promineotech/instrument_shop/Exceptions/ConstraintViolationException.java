/**
 * 
 */
package com.promineotech.instrument_shop.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author smith
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ConstraintViolationException extends RuntimeException {
  private String resourceName;
  private String fieldName;
  private Object findValue;
  
  public ConstraintViolationException(String resourceName, String fieldName, Object findValue) {
   super(String.format("%s is not a valid option for %s : '%s'", resourceName, fieldName, findValue));
   this.resourceName = resourceName;
   this.fieldName = fieldName;
   this.findValue = findValue;
  }
  
 public String getResouceName() {
   return resourceName;
 }
  
 public String getfieldName() {
   return fieldName;
 }
 
 public Object getfindValue() {
   return findValue;
 }
}
