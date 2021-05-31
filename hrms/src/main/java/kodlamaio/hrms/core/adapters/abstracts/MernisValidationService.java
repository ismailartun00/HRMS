package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.Candidate;

public interface MernisValidationService {
	boolean checkIfRealPerson(Candidate candidate);
}
