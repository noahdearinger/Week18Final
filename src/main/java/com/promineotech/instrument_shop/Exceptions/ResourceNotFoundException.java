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
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
  
  
  private String resourceName;
  private String fieldName;
  private Object findValue;

  public ResourceNotFoundException(String resourceName, String fieldName, Object findValue) {
      super(String.format("%s not found with %s : '%s'", resourceName, fieldName, findValue));
      this.resourceName = resourceName;
      this.fieldName = fieldName;
      this.findValue = findValue;
  }

  public String getResourceName() {
      return resourceName;
  }

  public String getFieldName() {
      return fieldName;
  }

  public Object getFindValue() {
      return findValue;
  }
  
  
  
  
  
  
//  @ExceptionHandler(NoSuchElementException.class)
//  @ResponseStatus(HttpStatus.NOT_FOUND)
//  public Map<String, Object> handleNoSuchElementException(
//      NoSuchElementException e, HttpStatus status) {
//    return createExceptionMessage(e, HttpStatus.NOT_FOUND);    
//  }
//  private Map<String, Object> createExceptionMessage(NoSuchElementException e, HttpStatus status) {
//  Map<String, Object> error = new HashMap<>();
//  error.put("message", e.toString());
//  error.put("status code", status.value());
//  error.put("reason", status.getReasonPhrase());
//    return error;
//  }

}
