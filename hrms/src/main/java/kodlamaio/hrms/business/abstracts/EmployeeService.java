package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService {
	DataResult<List<Employee>> getAll();
	DataResult<Employee> getById(int id);
	Result add(Employee employee);
	Result update(int id, Employee employee);
	Result delete(int id);
	Result existsEmployeeByEmailAddress(String emailAddress);
}
