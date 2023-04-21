package com.CH20444644.rating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CH20444644.rating.model.Distributions;

@Repository
public interface DistributionsRepository extends CrudRepository<Distributions, Integer> {
	

}
