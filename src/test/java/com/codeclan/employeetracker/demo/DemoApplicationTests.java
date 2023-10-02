package com.codeclan.employeetracker.demo;

import com.codeclan.employeetracker.demo.models.Department;
import com.codeclan.employeetracker.demo.models.Employee;
import com.codeclan.employeetracker.demo.models.Project;
import com.codeclan.employeetracker.demo.repositories.DepartmentRepository;
import com.codeclan.employeetracker.demo.repositories.EmployeeRepository;
import com.codeclan.employeetracker.demo.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}
	@Test
	public void canCreateEmployeeProjectDepartment(){
		Department sales = new Department("sales");
		departmentRepository.save(sales);
		Employee josh = new Employee("Josh", "Booker", 29, "josh.email@email", sales);
		employeeRepository.save(josh);
		Project project = new Project("Selling Stuff", 7);
		project.getEmployees().add(josh);
		projectRepository.save(project);
	}

}
