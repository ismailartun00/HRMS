package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {

	DataResult<List<Employer>> getAll();
	
	Result add(Employer employer);
	Result update(int id, Employer employer);
	Result delete(int id);
	
	Result getByEmailAddress(String emailAddress);
	Result getByCompanyName(String companyName);
	Result getByWebAddress(String webAddress);
	
}
