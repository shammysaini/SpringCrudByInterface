package springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import springboot.entity.Employee;

public interface EmployeeSevice {
	Employee getEmployeeById(long id);
	Employee addUser(Employee employee);
	List<Employee>getEmp();
	
	public Page<Employee>getAllEmpPagination(int cupage, int size);
	
}
