package kodlamaio.hrms.api.adapters;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {
	boolean checkIfRealPerson(Candidate candidate);
}
