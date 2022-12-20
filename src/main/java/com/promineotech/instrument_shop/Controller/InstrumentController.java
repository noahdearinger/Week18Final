/**
 * 
 */
package com.promineotech.instrument_shop.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.instrument_shop.Entity.Instrument;
import com.promineotech.instrument_shop.Service.InstrumentService;

/**
 * @author smith
 *
 */
@RestController
@RequestMapping("/instrument_shop/instruments")
public class InstrumentController {

  private InstrumentService instrumentService;
  
  public InstrumentController(InstrumentService instrumentService) {
    super();
    this.instrumentService = instrumentService;
  }
  
  @GetMapping
  public List<Instrument> getAllInstruments() {
    return instrumentService.getAllInstruments();
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}
