package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getByCompanyName(String companyName);
	
	Result add(Employer employer);
}
