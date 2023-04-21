package com.CH20444644.rating.service;

import java.util.List;

import com.CH20444644.rating.model.Assignments;

public interface AssignmentsService {

	Assignments createAssignments(Assignments assignment);

	List<Assignments> getAllAssignments();

	Assignments getAssignmentById(Integer assignmentId);

	Assignments updateAssignment(Assignments assignment);

	void deleteAssignment(Integer assignmentId);

}