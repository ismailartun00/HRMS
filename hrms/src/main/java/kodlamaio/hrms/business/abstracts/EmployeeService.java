package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
<<<<<<< HEAD
import kodlamaio.hrms.entities.dtos.EmployeeCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeViewDTO;

public interface EmployeeService {
	
	List<EmployeeViewDTO> getAll();
	
	EmployeeViewDTO add(EmployeeCreateDTO employeeCreateDto);
	EmployeeViewDTO update(int id, EmployeeUpdateDTO employeeUpdateDto);
	void delete(int id);
=======
import kodlamaio.hrms.entities.concretes.Employee;

public interface EmployeeService {
	
	DataResult<List<Employee>> getAll();
	
	Result add(Employee employee);
	Result update(int id, Employee employee);
	Result delete(int id);
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	
	Result getByEmailAddress(String emailAddress);
}
