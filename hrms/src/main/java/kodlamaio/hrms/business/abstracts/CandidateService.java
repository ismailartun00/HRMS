package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);
	Result update(int id, Candidate candidate);
	Result delete(int id);
	
	Result getByEmailAddress(String emailAddress);
	Result getByIdentificationNumber(String identificationNumber);
}
