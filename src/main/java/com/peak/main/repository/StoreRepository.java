package com.peak.main.repository;

import com.peak.main.model.Store;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StoreRepository extends MongoRepository<Store, String> {
    Optional<Store> findById(ObjectId id);
}
