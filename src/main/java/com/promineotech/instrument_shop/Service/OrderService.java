/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.List;
import com.promineotech.instrument_shop.Entity.Order;

/**
 * @author smith
 *
 */
public interface OrderService {

  
  public Order createOrder(Order order);
  
  public List<Order> getAllOrders();
  
  public Order getOrderById(int id);
  
  public Order editOrder(Order order, int id);
  
  public void deleteOrder(Order order, int id);
}
