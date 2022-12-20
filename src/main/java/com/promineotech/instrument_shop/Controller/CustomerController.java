/**
 * 
 */
package com.promineotech.instrument_shop.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.instrument_shop.Entity.Customer;
import com.promineotech.instrument_shop.Service.CustomerService;

/**
 * @author smith
 *
 */

@RestController
@RequestMapping("/instrument_shop/customers")
public class CustomerController {

  private CustomerService customerService;
  
  
  public CustomerController(CustomerService customerService) {
    super();
    this.customerService = customerService;
  }
  
  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
  }
  
  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }
  
  
  @GetMapping("{customer_name}")
  public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable("customer_name") String customerName) {
    return new ResponseEntity<List<Customer>>(customerService.getCustomerByName(customerName), HttpStatus.OK);
  }
  
  @PutMapping("{customer_id}")
  public ResponseEntity<Customer> editCustomer(@PathVariable("customer_id") int id, @RequestBody Customer customer) {
    return new ResponseEntity<Customer>(customerService.editCustomer(customer, id), HttpStatus.OK);
  }
  
  @DeleteMapping("{customer_id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable("customer_id") int id, @RequestBody Customer customer) {
    customerService.deleteCustomer(customer, id);
    return new ResponseEntity<String>("Customer: " + id + " was removed from database.", HttpStatus.OK);
  }
}
