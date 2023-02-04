package com.aman.microservices.core.recommendation.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import com.aman.api.core.recommendation.Recommendation;
import com.aman.api.core.recommendation.RecommendationService;
import com.aman.api.exceptions.InvalidInputException;
import com.aman.util.ServiceUtil;

@RestController
@ComponentScan("com.aman")
public class RecommendationServiceImpl implements RecommendationService{

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationService.class);

    private final ServiceUtil serviceUtil;

    public RecommendationServiceImpl(ServiceUtil serviceUtil){
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        if (productId < 1) {
            throw new InvalidInputException("Invalid productId: " + productId);
          }
      
          if (productId == 113) {
            LOG.debug("No recommendations found for productId: {}", productId);
            return new ArrayList<>();
          }
      
          List<Recommendation> list = new ArrayList<>();
          list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1", serviceUtil.getServiceAddress()));
          list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2", serviceUtil.getServiceAddress()));
          list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3", serviceUtil.getServiceAddress()));
      
          LOG.debug("/recommendation response size: {}", list.size());
      
          return list;    
        }
    
}
