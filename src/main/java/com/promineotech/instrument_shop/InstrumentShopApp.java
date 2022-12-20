/**
 * 
 */
package com.promineotech.instrument_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author smith
 *
 *Entry point for API
 *
 *Final project submission for Promineo Tech 18 week Back End bootcamp, API that performs CRUD
 *operations on a database for an instrument store that has customers, orders, and instruments.
 */
@SpringBootApplication
public class InstrumentShopApp {

  /**
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(InstrumentShopApp.class, args);

  }

}
