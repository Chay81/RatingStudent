package com.CH20444644.rating.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CH20444644.rating.model.Assignments;
import com.CH20444644.rating.model.Distributions;

@Repository
public interface AssignmentsRepository extends CrudRepository<Assignments, Integer> {
	

}
