package gn.traore.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import gn.traore.demo.models.Employee;
import gn.traore.demo.repo.EmployeeRepository;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByName(name);
	}

}
