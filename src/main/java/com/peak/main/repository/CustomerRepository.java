package com.peak.main.repository;

import com.peak.main.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<User, Integer> {
    Optional<User> findByName(String name);
}
