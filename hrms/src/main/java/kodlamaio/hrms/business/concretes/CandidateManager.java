package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.exceptions.NotFoundException;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCreateDTO;
import kodlamaio.hrms.entities.dtos.CandidateUpdateDTO;
import kodlamaio.hrms.entities.dtos.CandidateViewDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateManager implements CandidateService {

	private final CandidateDao candidateDao;
	
	@Override
	public List<CandidateViewDTO> getAll() {

		return candidateDao.findAll().stream().map(CandidateViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public CandidateViewDTO add(CandidateCreateDTO candidateCreateDTO) {
		
		final Candidate candidate = candidateDao.save(new Candidate(candidateCreateDTO.getEmailAddress(),
				candidateCreateDTO.getPassword(), candidateCreateDTO.getFirstName(), candidateCreateDTO.getLastName(),
				candidateCreateDTO.getIdentificationNumber(), candidateCreateDTO.getBirthOfDate()));
		
		return CandidateViewDTO.of(candidate);
	}

	@Override
	public CandidateViewDTO update(int id, CandidateUpdateDTO candidateUpdateDTO) {		
		
		final Candidate candidate = candidateDao.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		candidate.setFirstName(candidateUpdateDTO.getFirstName());
		candidate.setLastName(candidateUpdateDTO.getLastName());
		candidate.setIdentificationNumber(candidateUpdateDTO.getIdentificationNumber());
		candidate.setBirthOfDate(candidateUpdateDTO.getBirthOfDate());
		
		final Candidate updatedCandidate = candidateDao.save(candidate);
		return CandidateViewDTO.of(updatedCandidate);
	}

	@Override
	public void delete(int id) {
		final Candidate candidate = candidateDao.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		candidateDao.deleteById(candidate.getId());
	}

	@Override
	public Result getByEmailAddress(String emailAddress) {

		return new SuccessResult(emailAddress + " found");
	}

	@Override
	public Result getByIdentificationNumber(String identificationNumber) {
		
		return new SuccessResult(identificationNumber + " found");
	}

}
