package com.peak.main.repository;

import com.peak.main.model.SoldItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoldItemRepository extends MongoRepository<SoldItem, String> {
}
