package springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.entity.Employee;
import java.util.*;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("select u from Employee u")
	List<Employee> getAllEmployee();
	
	//@Query("from Employee as c where c.id =:empid")
	//public Page <Employee> getAllEmployeeByPage(@Param("empid")long id,Pageable pageable);
	
}
