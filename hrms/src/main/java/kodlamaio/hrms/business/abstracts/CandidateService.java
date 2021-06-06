package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateCreateDTO;
import kodlamaio.hrms.entities.dtos.CandidateUpdateDTO;
import kodlamaio.hrms.entities.dtos.CandidateViewDTO;

public interface CandidateService {

	List<CandidateViewDTO> getAll();
	
	CandidateViewDTO add(CandidateCreateDTO candidateCreateDto);
	CandidateViewDTO update(int id, CandidateUpdateDTO candidateUpdateDto);
	void delete(int id);
	
	Result getByEmailAddress(String emailAddress);
	Result getByIdentificationNumber(String identificationNumber);
}