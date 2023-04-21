package com.CH20444644.rating.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CH20444644.rating.model.Assignments;
import com.CH20444644.rating.model.Distributions;
import com.CH20444644.rating.repository.AssignmentsRepository;
import com.CH20444644.rating.service.AssignmentsService;

import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
public class AssignmentsServiceImpl implements AssignmentsService {

	private final AssignmentsRepository assignmentsRepository;

	@Override
	public Assignments createAssignments(Assignments assignment) {
		return assignmentsRepository.save(assignment);
	}


	@Override
	public List<Assignments> getAllAssignments() {
		return (List<Assignments>) assignmentsRepository.findAll();
	}


	@Override
	public Assignments getAssignmentById(Integer assignmentId) {
		Optional<Assignments> optionalId =  assignmentsRepository.findById(assignmentId);
		return optionalId.get();
		
	}


	@Override
	public Assignments updateAssignment(Assignments assignment) {
		Assignments existingAssignments = assignmentsRepository.findById(assignment.getSerial_number()).get();
		existingAssignments.setDateofsubmission(assignment.getDateofsubmission());
		existingAssignments.setPoints(assignment.getPoints());
		
		Assignments updatedAssignments = assignmentsRepository.save(existingAssignments);
        return updatedAssignments;
	}


	@Override
	public void deleteAssignment(Integer assignmentId) {
		assignmentsRepository.deleteById(assignmentId);		
	}

}