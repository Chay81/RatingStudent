package com.CH20444644.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CH20444644.rating.model.Distributions;
import com.CH20444644.rating.service.AssignmentsService;
import com.CH20444644.rating.service.DistributionsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apiv2")
public class DistributionsController {

	private DistributionsService distributionsService;
	
//	Constructor based Dependency Injection
	@Autowired
	DistributionsController(DistributionsService distributionsService){
		this.distributionsService=distributionsService; 
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Distributions>> getAllDistributions() {
		List<Distributions> distributions = distributionsService.getAllDistributions();
		return new ResponseEntity<>(distributions, HttpStatus.OK);
	}

	@GetMapping("/getAll/{id}")
	public ResponseEntity<Distributions> getUserById(@PathVariable("id") Integer distributeId) {
		Distributions userId = distributionsService.getDistributionById(distributeId);
		return new ResponseEntity<>(userId, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Distributions> saveDistributions(@RequestBody Distributions distribute) {

		Distributions distributeRequest = distributionsService.createDistributions(distribute);
		return new ResponseEntity<>(distributeRequest, HttpStatus.CREATED);

	}

	@PutMapping("{id}")
	public ResponseEntity<Distributions> updateDistribute(@PathVariable("id") Integer distributeId,
			@RequestBody Distributions distribute) {

		distribute.setId(distributeId);

		Distributions updatedDistribution = distributionsService.updateDistribute(distribute);
		return new ResponseEntity<>(updatedDistribution, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteDistribute(@PathVariable("id") Integer distributeId) {

		distributionsService.deleteDistribute(distributeId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);

	}
}
