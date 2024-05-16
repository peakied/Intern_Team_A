package com.peak.main.repository;

import com.peak.main.model.Promotion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PromotionRespository extends MongoRepository<Promotion, String> {
}
