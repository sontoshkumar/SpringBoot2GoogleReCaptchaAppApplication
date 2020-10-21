package in.nit.sontosh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.sontosh.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
