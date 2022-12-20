/**
 * 
 */
package com.promineotech.instrument_shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.promineotech.instrument_shop.Entity.Instrument;

/**
 * @author smith
 *
 */
@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Integer> {

}
