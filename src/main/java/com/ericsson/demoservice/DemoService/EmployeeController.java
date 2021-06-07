package com.ericsson.demoservice.DemoService;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private Employee employee;
	Map<Integer, Employee> empData = new HashMap<Integer, Employee>();
	
	
	@RequestMapping("/emp/createDummy")
	public void createDummyEmpoyee() {
		employee.setId(1001); employee.setName("Abhigyan");
		empData.put(1001, employee);
		System.out.println("Created Employee Details"+ employee);
	}
	
	@RequestMapping("/emp/dummyEmp")
	public String getDummyEmpoyeeName() {
		System.out.println("Employee Name"+ employee.getName());
		return "EmpName";
	}

	@RequestMapping("/emp/{id}") public @ResponseBody Employee
	getEmployee(@PathVariable("id") int empId){
		System.out.println("Returning Emp" + empData.get(empId));
		return empData.get(empId);
	}
	
/*	  @RequestMapping(value = "/emp/create/{id}/{name}", method =
	  RequestMethod.POST) public Employee createEmployee(@PathVariable("id") int
	  empId, @PathVariable("name") String name){ Employee emp = new Employee();
	  emp.setId(empId); emp.setName(name); empData.put(empId, emp);
	  
	  return emp; }*/
	 
	
	@PostMapping(value = "/emp/create", consumes = "application/json")
	public void createEmployee(@RequestBody Employee emp) {
		empData.put(emp.getId(), emp);
	}
	 
}

