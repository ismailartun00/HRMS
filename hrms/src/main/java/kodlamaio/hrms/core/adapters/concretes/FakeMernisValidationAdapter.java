package kodlamaio.hrms.core.adapters.concretes;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.Candidate;

@Component
public class FakeMernisValidationAdapter implements MernisValidationService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		return true;
	}

}