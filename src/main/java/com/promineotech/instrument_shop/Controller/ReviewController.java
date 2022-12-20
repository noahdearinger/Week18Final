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
import com.promineotech.instrument_shop.Entity.Review;
import com.promineotech.instrument_shop.Service.ReviewService;

/**
 * @author smith
 *
 */
@RestController
@RequestMapping("/instrument_shop/reviews")
public class ReviewController {

  private ReviewService reviewService;
  
  public ReviewController(ReviewService reviewService) {
    super();
    this.reviewService = reviewService;
  }
  
  @PostMapping
  public ResponseEntity<Review> createReview(@RequestBody Review review) {
    
    return new ResponseEntity<Review>(reviewService.createReview(review), HttpStatus.CREATED); 
  }
  
  @GetMapping
  public List<Review> getAllReviews() {
    
    return reviewService.getAllReviews();
  }
  
  @PutMapping("{review_id}")
  public ResponseEntity<Review> editReview(@PathVariable("review_id") int id, @RequestBody Review review) {
    
    return new ResponseEntity<Review>(reviewService.editReview(review, id), HttpStatus.OK);
  }
  
  @DeleteMapping("{review_id}")
  public ResponseEntity<String> deleteReview(@PathVariable("review_id") int id, @RequestBody Review review) {
    reviewService.deleteReview(review, id);
    return new ResponseEntity<String>("Review: " + id + " was deleted.", HttpStatus.OK);
  }
}
