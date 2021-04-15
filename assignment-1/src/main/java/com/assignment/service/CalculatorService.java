package com.assignment.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.model.CalculatorModel;
import com.assignment.repository.CalculatorRepository;
@Service
public class CalculatorService {
	 @Autowired
	 CalculatorRepository calculatorRepository;
	 
	 
 public String postResult(CalculatorModel calculatorModel) {
	
	 
	 
	 String result="";
	 float calculate;
	 String operationName=calculatorModel.getOperationName();
	 float number1=calculatorModel.getNumber1();
	 
	 float number2=calculatorModel.getNumber2();
	 if(operationName.equals("Addition")) {
		 calculate=number1+number2;
		 result=operationName+" of "+number1+" and "+number2+" is "+calculate;
		 calculatorModel.setResult(calculate);
		 calculatorRepository.save(calculatorModel);
		 
	 }
	 else if(operationName.equals("Subtract")) {
		 calculate=number1-number2;
		 result=operationName+" of "+number1+" and "+number2+" is "+calculate;
		 calculatorModel.setResult(calculate);
		 calculatorRepository.save(calculatorModel);
	 }
	 else if(operationName.equals("Multiplication")) {
		 calculate=number1*number2;
		 result=operationName+" of "+number1+" and "+number2+" is "+calculate;
		 calculatorModel.setResult(calculate);
		 calculatorRepository.save(calculatorModel);
	 }
	 else if(operationName.equals("Divide")) {
		 calculate=number1/number2;
		 result=operationName+" of "+number1+" and "+number2+" is "+calculate;
		 calculatorModel.setResult(calculate);
		 calculatorRepository.save(calculatorModel);
	 }
	 else if(operationName.equals("Modulus")) {
		 calculate=number1%number2;
		 result=operationName+" of "+number1+" and "+number2+" is "+calculate;
		 calculatorModel.setResult(calculate);
		 calculatorRepository.save(calculatorModel);
	 }
	 else  {
		 result="Invalid input";
	 }
	return result;
	 
 }

public List<String> getResult() {
	// TODO Auto-generated method stub
	List<String> result=new ArrayList<String>();
	List<CalculatorModel> l=calculatorRepository.findAll();
	for(int i=0;i<l.size();i++) {
		String temp=i+1+". "+l.get(i).getOperationName()+" Numbers , number1="+l.get(i).getNumber1()+" and number2 "+l.get(i).getNumber2();
		result.add(temp);
	    
	}
	return result;
}

public CalculatorModel getResultById(int id) {
	// TODO Auto-generated method stub
	CalculatorModel calculatorModel=calculatorRepository.getResultById(id);
	return calculatorModel;
}
}
