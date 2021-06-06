package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeViewDTO;

public interface EmployeeService {
	
	List<EmployeeViewDTO> getAll();
	
	EmployeeViewDTO add(EmployeeCreateDTO employeeCreateDto);
	EmployeeViewDTO update(int id, EmployeeUpdateDTO employeeUpdateDto);
	void delete(int id);
	
	Employee getByEmailAddress(String emailAddress);
}