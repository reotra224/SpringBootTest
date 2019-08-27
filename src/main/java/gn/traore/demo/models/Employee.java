package gn.traore.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    @Size(min = 3, max = 20)
    private String name;

	public Employee() {
	}

	public Employee(@Size(min = 3, max = 20) String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
