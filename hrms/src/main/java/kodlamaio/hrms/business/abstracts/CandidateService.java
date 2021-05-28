package  kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
	Result add(Candidate candidate);
	Result update(int id, Candidate candidate);
	Result delete(int id);
	boolean existsCandidateByIdentificationNumber(String identificationNumber);
	boolean existsCandidateByEmailAddress(String emailAddress);
	boolean hasEmptyField(Candidate candidate);
}
