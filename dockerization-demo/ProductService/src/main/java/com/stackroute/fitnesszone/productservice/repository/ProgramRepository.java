package com.stackroute.fitnesszone.productservice.repository;

import com.stackroute.fitnesszone.productservice.entity.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends MongoRepository<Program,String> {

    List<Program> findByActiveTrue();

    List<Program> findByDurationInMonths(int durationInMonths);
}
