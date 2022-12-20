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
@Table(name = "reviews")
public class Review {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(value = "review_id")
  private int reviewId;
  
  @Column(value = "customer_id")
  private int customerId;
  
  @Column(value = "text_body")
  private String textBody;
}
