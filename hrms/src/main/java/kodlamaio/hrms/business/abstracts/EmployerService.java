package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dtos.EmployerCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployerUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployerViewDTO;

public interface EmployerService {

	List<EmployerViewDTO> getAll();
	
	EmployerViewDTO add(EmployerCreateDTO employerCreateDto);
	EmployerViewDTO update(int id, EmployerUpdateDTO employerUpdateDto);
	void delete(int id);
	
	Result getByEmailAddress(String emailAddress);
	Result getByCompanyName(String companyName);
	Result getByWebAddress(String webAddress);
	
}