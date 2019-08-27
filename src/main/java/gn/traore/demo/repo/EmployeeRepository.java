package gn.traore.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import gn.traore.demo.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee findByName(String name);
}
