/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.List;
import com.promineotech.instrument_shop.Entity.Review;

/**
 * @author smith
 *
 */
public interface ReviewService {

  public List<Review> getAllReviews();
  
  public Review createReview(Review review);
  
  public Review editReview(Review review, int id);
  
  public void deleteReview(Review review, int id);
  
  
  
  
  
  
  
}
