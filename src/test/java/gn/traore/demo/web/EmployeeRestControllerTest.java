package gn.traore.demo.web;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import gn.traore.demo.models.Employee;
import gn.traore.demo.services.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeRestController.class)
//@WebMvcTest(value = SessionController.class, secure = false)
public class EmployeeRestControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService employeeService;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Test
	public void devraTrouverTousLesEmployes() throws Exception {
		given(this.employeeService.getAllEmployees())
			.willReturn(Arrays.asList(
					new Employee("Alex"),
					new Employee("Traoré")
			)
		);
		this.mvc.perform(get("/api/employees")) //.with(httpBasic("admin", "password")))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.length()", is(2)))
			.andExpect(jsonPath("$[0].name", is("Alex"))
		);
	}

//	@Test
//	public void devraCreerUnEmployes() throws Exception {
//		
//		Employee empl = new Employee("Kaba");
//		
//		given(this.employeeService.saveEmployee(empl))
//			.willReturn(empl);
//			
//		this.mvc.perform(post("/api/employees")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(empl))
//			)
//			.andExpect(status().isOk())
//			.andExpect(jsonPath("name", is("Kaba"))
//		);
//	}

}
