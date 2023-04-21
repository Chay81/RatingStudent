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
@Table(name = "DB_Distribtions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Distributions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "assignment_category1", unique = true)
	private String AssignmentCategory;
	private Double Weight;
	

}
