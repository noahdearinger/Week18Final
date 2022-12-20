/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.List;
import com.promineotech.instrument_shop.Entity.Customer;

/**
 * @author smith
 *
 */
public interface CustomerService {

  public Customer createCustomer(Customer customer);
  
  public List<Customer> getAllCustomers();
  
  public List<Customer> getCustomerByName(String customerName); //change return to Customer, see how to fix repository
  
  public Customer editCustomer(Customer customer, int customerId);
  
  public void deleteCustomer(Customer customer, int customerId);
}
