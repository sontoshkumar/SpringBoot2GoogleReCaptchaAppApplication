package in.nit.sontosh.service;

import java.util.List;

import in.nit.sontosh.model.Employee;

public interface EmployeeService {

	Integer createEmployee(Employee e);

	List<Employee> getAllEmployee();

}
