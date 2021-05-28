package  kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.api.adapters.MernisServiceAdapter;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class CandidateManager implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;
	private MernisServiceAdapter mernisServiceAdapter = new MernisServiceAdapter();

	
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>("Candidate are Listed", this.candidateDao.findAll());
	}
	
	
	@Override
	public DataResult<Candidate> getById(int id) {
		if (this.candidateDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<Candidate>("The id already existed", this.candidateDao.findById(id).get());
		} else {
			return new ErrorDataResult<Candidate>("The id did not exist.");
		}
	}
	
	
	@Override
	public Result add(Candidate candidate){
		
		if (!this.hasEmptyField(candidate)) {
			return new ErrorResult("All fields are required.");
		} else if(!mernisServiceAdapter.mernisValidate (candidate.getIdentificationNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthOfDate().getYear())){
			
			return new ErrorResult("Kimlik doğrulaması başarısız.");
		}
		
		else {
            this.candidateDao.save(candidate);
            return new SuccessResult("iş arayan başarıyla kaydedildi.");
        }
	}
	
	
	
	@Override
	public Result update(int id, Candidate candidate) {
		if(candidateDao.getOne(id) == null) {
			return new ErrorResult("User Does not Exist");
		}	
		candidateDao.save(candidate);
		return new SuccessResult("Candidate is Updated");
	}
	
	
	@Override
	public Result delete(int id) {
		if(candidateDao.getOne(id) == null) {
			return new ErrorResult("Id of Candidate is Null");
		}
		candidateDao.deleteById(id);
		return new SuccessResult("Candidate is Deleted");
	}
	
	
	@Override
	public boolean existsCandidateByIdentificationNumber(String identificationNumber) {
		return this.candidateDao.existsCandidateByIdentificationNumber(identificationNumber);
	}
	
	
	@Override
	public boolean existsCandidateByEmailAddress(String emailAddress) {
		return this.candidateDao.existsCandidateByEmailAddress(emailAddress);
	}
	
	
	@Override
	public boolean hasEmptyField(Candidate candidate){
		if (candidate.getFirstName() == null || candidate.getFirstName().equals("") || candidate.getLastName() == null || candidate.getLastName().equals("") 
				|| candidate.getBirthOfDate() == null || candidate.getEmailAddress() == null || candidate.getEmailAddress().equals("") || candidate.getIdentificationNumber() == null 
				|| candidate.getIdentificationNumber().equals("") || candidate.getPassword() == null || candidate.getPassword().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	
}
