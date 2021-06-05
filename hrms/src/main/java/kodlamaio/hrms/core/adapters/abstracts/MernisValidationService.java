package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisValidationService {
	boolean checkIfRealPerson(Candidate candidate);
}
