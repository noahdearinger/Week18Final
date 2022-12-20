/**
 * 
 */
package com.promineotech.instrument_shop.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotech.instrument_shop.Entity.Review;
import com.promineotech.instrument_shop.Exceptions.ConstraintViolationException;
import com.promineotech.instrument_shop.Exceptions.ResourceNotFoundException;
import com.promineotech.instrument_shop.Repository.ReviewRepository;

/**
 * @author smith
 *
 */
@Service
public class ReviewServiceImp implements ReviewService {

  private ReviewRepository reviewRepository;

  @Autowired
  public ReviewServiceImp(ReviewRepository reviewRepository) {
    this.reviewRepository = reviewRepository;
  }

  @Override
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  @Override
  public Review createReview(Review review) {
    int id = review.getReviewId();

    if (reviewRepository.existsById(id)) {
      throw new ConstraintViolationException("Review", "Id", id);
    }

    return reviewRepository.save(review);
  }

  @Override
  public Review editReview(Review review, int id) {
    Review currentReview = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review", "Id", id));

    currentReview.setCustomerId(review.getCustomerId());
    currentReview.setReviewId(review.getReviewId());
    currentReview.setTextBody(review.getTextBody());

    reviewRepository.save(currentReview);
    return currentReview;
  }


  @Override
  public void deleteReview(Review review, int id) {
    Review currentReview = reviewRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Review", "Id", id));

    reviewRepository.delete(currentReview);
  }

}
