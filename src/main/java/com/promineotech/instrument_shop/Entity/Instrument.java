/**
 * 
 */
package com.promineotech.instrument_shop.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;
import lombok.Data;

/**
 * @author smith
 *
 */

@Data 
@Entity
@Table(name = "instruments")
public class Instrument {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(value = "instrument_id")
  private String instrumentId;
  
  @Column(value = "make")
  private String make;
  
  @Column(value = "model")
  private String model;
  
  @Column(value = "description")
  private String description;
  
  @Column(value = "price")
  private double price;
  
  
}
