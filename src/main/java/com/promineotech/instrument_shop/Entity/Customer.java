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
@Table(name = "customers")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(value = "customer_id")
  private int customerId;
  
  @Column(value = "address")
  private String address;
  
  @Column(value = "phone_number")
  private String phoneNumber;
  
  @Column(value = "customer_name")
  private String customerName;
  
  
}
