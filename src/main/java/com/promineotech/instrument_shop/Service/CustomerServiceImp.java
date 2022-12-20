/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.instrument_shop.Entity.Customer;
import com.promineotech.instrument_shop.Exceptions.ConstraintViolationException;
import com.promineotech.instrument_shop.Exceptions.ResourceNotFoundException;
import com.promineotech.instrument_shop.Repository.CustomerRepository;

/**
 * @author smith
 *
 *
 */
@Service
public class CustomerServiceImp implements CustomerService {

  private CustomerRepository customerRepository;

  @Autowired
  public CustomerServiceImp(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }


  @Override // saves customer, unless one by id already exists, then throws CVE
  public Customer createCustomer(Customer customer) {
    int id = customer.getCustomerId();

    if (customerRepository.existsById(id)) {
      throw new ConstraintViolationException("Review", "Id", id);
    }
    return customerRepository.save(customer);
  }

  @Override // finds all customers as a list
  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  @Override //using customer Id, return customer
  public List<Customer> getCustomerByName(String customerName) {
    List<Customer> customers = customerRepository.findAll();
    List<Customer> returnedCustomer = new ArrayList<>();
        customers.stream().forEach(c -> {if(c.getCustomerName().equalsIgnoreCase(customerName))
          returnedCustomer.add(c); });  //.equals?, .forEachOrdered?
      
//   for (Customer c : customers) {
//      if(c.getCustomerName().equalsIgnoreCase(customerName))
//        returnedCustomer.add(c);
//    }
    return returnedCustomer;
  }

  @Override
  public Customer editCustomer(Customer customer, int customerId) {
   Customer currentCustomer = customerRepository.findById(customerId)
       .orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
    
   //currentCustomer.setCustomerId(customer.getCustomerId());
   currentCustomer.setAddress(customer.getAddress());
   currentCustomer.setPhoneNumber(customer.getPhoneNumber());
   currentCustomer.setCustomerName(customer.getCustomerName());
   
   customerRepository.save(currentCustomer);
   return currentCustomer;
  }

  @Override
  public void deleteCustomer(Customer customer, int customerId) {
   Customer currentCustomer = customerRepository.findById(customerId)
       .orElseThrow(() -> new ResourceNotFoundException("Customer", "Id", customerId));
         customerRepository.delete(currentCustomer);
  }


}
