package in.nit.sontosh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.sontosh.model.Employee;
import in.nit.sontosh.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer createEmployee(Employee e) {
		return repo.save(e).getId();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

}
