package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;
<<<<<<< HEAD
import kodlamaio.hrms.entities.dtos.CandidateCreateDTO;
import kodlamaio.hrms.entities.dtos.CandidateUpdateDTO;
import kodlamaio.hrms.entities.dtos.CandidateViewDTO;

public interface CandidateService {

	List<CandidateViewDTO> getAll();
	
	CandidateViewDTO add(CandidateCreateDTO candidateCreateDto);
	CandidateViewDTO update(int id, CandidateUpdateDTO candidateUpdateDto);
	void delete(int id);
	
=======
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	
	Result add(Candidate candidate);
	Result update(int id, Candidate candidate);
	Result delete(int id);
	
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	Result getByEmailAddress(String emailAddress);
	Result getByIdentificationNumber(String identificationNumber);
}
