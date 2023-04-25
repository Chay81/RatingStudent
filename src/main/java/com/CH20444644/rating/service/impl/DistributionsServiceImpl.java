package com.CH20444644.rating.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CH20444644.rating.model.Distributions;
import com.CH20444644.rating.repository.AssignmentsRepository;
import com.CH20444644.rating.repository.DistributionsRepository;
import com.CH20444644.rating.service.DistributionsService;

import lombok.RequiredArgsConstructor;

// to be kept in dto/controller level, @Transactional
@Transactional
@Service
@RequiredArgsConstructor
public class DistributionsServiceImpl implements DistributionsService {

	private DistributionsRepository distributionsRepository;
	
//	Constructor based Dependency Injection
	@Autowired
	DistributionsServiceImpl(DistributionsRepository distributionsRepository){
		this.distributionsRepository=distributionsRepository;
	}

	@Override
	public Distributions createDistributions(Distributions distribute) {
		return distributionsRepository.save(distribute);
	}

	@Override
	public List<Distributions> getAllDistributions() {
		return (List<Distributions>) distributionsRepository.findAll();
	}

	@Override
	public Distributions getDistributionById(Integer distributeId) {
		Optional<Distributions> optionalId =  distributionsRepository.findById(distributeId);
		return optionalId.get();
	}

	@Override
	public Distributions updateDistribute(Distributions distribute) {
		Distributions existingDistribute = distributionsRepository.findById(distribute.getId()).get();
		existingDistribute.setWeight(distribute.getWeight());
		
		Distributions updatedDistribution = distributionsRepository.save(existingDistribute);
        return updatedDistribution;
	}

	@Override
	public void deleteDistribute(Integer distributeId) {
		distributionsRepository.deleteById(distributeId);
	}

}