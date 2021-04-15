package com.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Calculator")
public class CalculatorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String operationName;

	@NotNull(message = "number1 is required")
	private float number1;

	@NotNull(message = "number2 is required")
	private float number2;

	private float result;

}
