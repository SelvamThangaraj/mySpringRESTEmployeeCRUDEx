package com.examples.spring.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.examples.spring.web.mvc.service.EmployeeService;
import com.examples.spring.web.rest.model.Employee;



@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/employee", method = RequestMethod.POST,  consumes = { "application/xml",
	"application/json" })
	public HttpEntity<String> addEmployee(@RequestBody Employee employee) {

		empService.add(employee);

		return new ResponseEntity<String>(employee.getId(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/employee", method = RequestMethod.GET,  produces = { "application/xml",
	"application/json" })
	public HttpEntity<List<Employee>> listEmployee() {

		List<Employee> listEmp=empService.list();

		return new ResponseEntity <List<Employee>>(listEmp,HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE , produces = { "text/xml"})
	public HttpEntity<String> deleteEmployee(@PathVariable String empId) {

		empService.delete(empId);

		return new ResponseEntity<String>(empId +" is deleted",HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET,  produces = { "application/xml",
	"application/json" })
	public ResponseEntity<Employee> getEmployee(@PathVariable String empId) {

		Employee employee =empService.get(empId);
        System.out.println(employee);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	//@PutMapping("/employee/{id}")
	@RequestMapping(value = "/employee", method = RequestMethod.PUT,  produces = { "application/xml",
	"application/json" })
	public HttpEntity<? extends Object> updateEmployee(@RequestBody Employee employee) {

		//employee.setId(id);
		empService.update(employee);

		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
}
