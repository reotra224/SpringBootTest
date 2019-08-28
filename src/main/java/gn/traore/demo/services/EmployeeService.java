package gn.traore.demo.services;

import java.util.List;

import gn.traore.demo.models.Employee;

public interface EmployeeService {
	
	public Employee getEmployeeByName(String name);

	public Employee getEmployeeById(Long id);
	
	public List<Employee> getAllEmployees();

	public Employee saveEmployee(Employee emp);
}
