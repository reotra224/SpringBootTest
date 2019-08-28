package gn.traore.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gn.traore.demo.models.Employee;
import gn.traore.demo.repo.EmployeeRepository;
import gn.traore.demo.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/employees")
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getOne(@PathVariable("id") Long id) {
		Employee emp = employeeService.getEmployeeById(id);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emp);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> saveOne(@RequestBody Employee emp) {
		Employee empl = employeeService.saveEmployee(emp);
		return ResponseEntity.ok(empl);
	}

}
