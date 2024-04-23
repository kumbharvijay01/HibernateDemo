/**
 * 
 */
package com.org.fb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * 
 */
@Data
@Entity
@Table(name = "StudentData")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "studID")
	private int id;
	@Column(name = "stud_Name", length = 1000)
	private String name;
	@Column(name = "stud_address", length = 1000)
	private String address;
	@Column(name = "stud_std", length = 1000)
	private String std;

	private String marksObtained;

	private String gender;

}
