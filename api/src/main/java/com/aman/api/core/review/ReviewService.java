package com.aman.api.core.review;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * API interface for review
 */
public interface ReviewService {
    @GetMapping(value = "/review", produces = "application/json")
    List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);
}
