package gn.traore.demo.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import gn.traore.demo.models.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EmployeeRepository employeeRepository;

	public EmployeeRepositoryIntegrationTest() {}

	@Test
	public void whenFindByName_thenReturnEmployee() {
	    // given
		Employee traore = new Employee("traoré"); Employee alex = new
		Employee("alex"); entityManager.persist(alex); entityManager.persist(traore);
		entityManager.flush();

		// when
		Employee found = employeeRepository.findByName("traoré");

		// then
		// assertThat(found.getName()).isEqualTo(alex.getName());
		assertThat(found.getName()).isNotEqualTo(alex.getName());

	}
}
