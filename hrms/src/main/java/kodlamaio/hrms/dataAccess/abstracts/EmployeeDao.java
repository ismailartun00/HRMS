package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
