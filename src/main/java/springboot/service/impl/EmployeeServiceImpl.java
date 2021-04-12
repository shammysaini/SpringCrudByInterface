package springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import springboot.entity.Employee;

import springboot.repository.EmployeeRepository;
import springboot.service.EmployeeSevice;
@Service
public class EmployeeServiceImpl implements EmployeeSevice {
	
	@Autowired EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(long id) {
		Employee employee=	employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		
		
		return employee;
		
		
		
	}

	@Override
	public Employee addUser(Employee employee) {
		
		
		
		return employeeRepository.save(employee);
		
		
	}

	
	@Override
	public List<Employee> getEmp() {
			return employeeRepository.getAllEmployee();
		
	
	}
	

	
	@Override
	public Page<Employee> getAllEmpPagination(int cupage, int size) {
		Employee employee = new Employee();
		Pageable pageable = PageRequest.of(cupage, size);	
		Page<Employee> pemployee =employeeRepository.findAll(pageable);
		return pemployee;
		
	}
	

	

}
