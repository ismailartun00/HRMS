package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	DataResult<Employer> getById(int id);
	Result add(Employer employer);
	Result update(int id, Employer employer);
	Result delete(int id);
	boolean existsEmployerByEmailAddress(String emailAddress);
	boolean hasEmptyField(Employer employer);
}