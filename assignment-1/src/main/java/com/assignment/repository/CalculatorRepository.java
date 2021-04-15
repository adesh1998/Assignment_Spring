package com.assignment.repository;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.model.CalculatorModel;

public interface CalculatorRepository extends JpaRepository<CalculatorModel, Integer> {

	@Query(name = "SELECT * FROM Calculator where id=id", nativeQuery = true)
	CalculatorModel getResultById(@PathParam("id") int id);
}
