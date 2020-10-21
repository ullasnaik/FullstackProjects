package com.stackroute.newz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.stackroute.newz.model.News;

/*
* This class is implementing the JpaRepository interface for News.
* Annotate this class with @Repository annotation
* */

@Repository 
public interface NewsRepository extends JpaRepository<News, Integer> {

}
