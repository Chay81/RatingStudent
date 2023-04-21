package com.CH20444644.rating.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DB_Assignments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assignments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serial_number;
	private String studentName;
	private String subject;
	@Column(name = "assignment_category2")
	private String assignmentcategory;
	@Column(name = "date_of_submission")
	private String dateofsubmission;
	private int points;
	

}
