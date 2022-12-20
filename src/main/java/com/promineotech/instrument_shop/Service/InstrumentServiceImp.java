/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.instrument_shop.Entity.Instrument;
import com.promineotech.instrument_shop.Repository.InstrumentRepository;

/**
 * @author smith
 *
 */
@Service
public class InstrumentServiceImp implements InstrumentService {

  private InstrumentRepository instrumentRepository;
  
  @Autowired
  public InstrumentServiceImp(InstrumentRepository instrumentRepository) {
    this.instrumentRepository = instrumentRepository;
  }
  @Override
  public List<Instrument> getAllInstruments() {
    
    return instrumentRepository.findAll();
  }

}
