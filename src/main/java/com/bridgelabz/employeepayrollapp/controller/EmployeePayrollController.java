package com.bridgelabz.employeepayrollapp.controller;

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

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrolldata;

@RestController
@RequestMapping("/employeePayrollservice")
public class EmployeePayrollController {
	@RequestMapping("/get")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		EmployeePayrolldata employeePayrollData = null;
		employeePayrollData = new EmployeePayrolldata(1, new EmployeePayrollDTO("Shilpa", 30000));
		ResponseDTO respDTO = new ResponseDTO("Get call Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId) {
		EmployeePayrolldata employeePayrollData = null;
		employeePayrollData = new EmployeePayrolldata(empId, new EmployeePayrollDTO("vaishali", 30000));
		ResponseDTO respDTO = new ResponseDTO("Get call for ID Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrolldata employeePayrollData = null;
		employeePayrollData = new EmployeePayrolldata(1, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Create Employee PayrollData:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId,
			@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrolldata employeePayrollData = null;
		employeePayrollData = new EmployeePayrolldata(empId, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Update Employee PayrollData Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
		ResponseDTO respDTO = new ResponseDTO("Deleted Successful,Deleted Id:", empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}