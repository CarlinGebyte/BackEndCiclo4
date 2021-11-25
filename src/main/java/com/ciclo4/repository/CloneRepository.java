package com.ciclo4.repository;

import com.ciclo4.model.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloneRepository extends MongoRepository<Clone, Integer> {
}
