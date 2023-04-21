package com.CH20444644.rating.controller;

import java.util.List;

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

import com.CH20444644.rating.model.Assignments;
import com.CH20444644.rating.service.AssignmentsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/apiv1")
public class AssignmentsController {

	private final AssignmentsService assignmentsService;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Assignments>> getAllDistributions() {
		List<Assignments> assignments = assignmentsService.getAllAssignments();
		return new ResponseEntity<>(assignments, HttpStatus.OK);
	}
	
	@GetMapping("/getAll/{id}")
	public ResponseEntity<Assignments> getAssignmentById(@PathVariable("id") Integer assignmentId) {
		Assignments userId = assignmentsService.getAssignmentById(assignmentId);
		return new ResponseEntity<>(userId, HttpStatus.OK);
	}
	
	@PostMapping("/assigncreate")
	public ResponseEntity<Assignments> saveAssignments(@RequestBody Assignments assignment) {

		Assignments assignmentRequest = assignmentsService.createAssignments(assignment);
		return new ResponseEntity<>(assignmentRequest, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Assignments> updateAssignment(@PathVariable("id") Integer assignmentId,
			@RequestBody Assignments assignment) {

		assignment.setSerial_number(assignmentId);

		Assignments updateAssignment = assignmentsService.updateAssignment(assignment);
		return new ResponseEntity<>(updateAssignment, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAssignment(@PathVariable("id") Integer assignmentId) {

		assignmentsService.deleteAssignment(assignmentId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
}
