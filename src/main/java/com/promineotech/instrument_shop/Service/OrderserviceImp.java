/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.instrument_shop.Entity.Order;
import com.promineotech.instrument_shop.Exceptions.ConstraintViolationException;
import com.promineotech.instrument_shop.Exceptions.ResourceNotFoundException;
import com.promineotech.instrument_shop.Repository.OrderRepository;

/**
 * @author smith
 *
 */
@Service
public class OrderserviceImp implements OrderService {
  
  private OrderRepository orderRepository;
  
  
  @Autowired
  public OrderserviceImp(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }
  @Override
  public Order createOrder(Order order) {
    int id = order.getOrderId();
    if(orderRepository.existsById(id)) {
      throw new ConstraintViolationException("Order already exists!", "Id", id);
    }
    return orderRepository.save(order);
  }

  @Override
  public List<Order> getAllOrders() {
    
    return orderRepository.findAll();
  }

  @Override
  public Order getOrderById(int id) {
    
    return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
  }

  @Override
  public Order editOrder(Order order, int id) {

    Order currentOrder = orderRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
    
    // currentOrder.setOrderId(order.getOrderId());
    currentOrder.setCustomerId(order.getCustomerId());
    currentOrder.setOrderDate(order.getOrderDate());
    
      orderRepository.save(currentOrder);
    return currentOrder;
  }

  @Override
  public void deleteOrder(Order order, int id) {
    Order currentOrder = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "Id", id));
    
    orderRepository.deleteById(id);
  }

}
