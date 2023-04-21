package com.CH20444644.rating.service;

import java.util.List;

import com.CH20444644.rating.model.Distributions;

public interface DistributionsService {

Distributions createDistributions(Distributions distribute); 

List<Distributions> getAllDistributions();

Distributions getDistributionById(Integer distributeId);

Distributions updateDistribute(Distributions distribute);

void deleteDistribute(Integer distributeId);

}