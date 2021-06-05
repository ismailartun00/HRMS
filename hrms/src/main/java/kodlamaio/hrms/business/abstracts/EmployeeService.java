package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployeeCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeViewDTO;

public interface EmployeeService {
	
	List<EmployeeViewDTO> getAll();
	
	EmployeeViewDTO add(EmployeeCreateDTO employeeCreateDto);
	EmployeeViewDTO update(int id, EmployeeUpdateDTO employeeUpdateDto);
	void delete(int id);
	
	Result getByEmailAddress(String emailAddress);
}
