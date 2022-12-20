/**
 * 
 */
package com.promineotech.instrument_shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineotech.instrument_shop.Entity.Order;

/**
 * @author smith
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
