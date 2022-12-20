/**
 * 
 */
package com.promineotech.instrument_shop.Entity;

import java.sql.Date;
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
@Table(name = "orders")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(value = "order_id")
  private int orderId;
  
  @Column(value = "customer_id")
  private int customerId;
  
  @Column(value = "order_date")
  private Date orderDate;
}
