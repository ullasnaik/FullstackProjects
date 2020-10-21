package com.stackroute.fitnesszone.productservice.repository;

import com.stackroute.fitnesszone.productservice.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends MongoRepository<Program,String> {
}
