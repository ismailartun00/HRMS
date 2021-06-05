package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
<<<<<<< HEAD
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
	
=======
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	Result update(int id, Employer employer);
	Result delete(int id);
	
	Result getByEmailAddress(String emailAddress);
	Result getByCompanyName(String companyName);
	Result getByWebAddress(String webAddress);
	
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
}
