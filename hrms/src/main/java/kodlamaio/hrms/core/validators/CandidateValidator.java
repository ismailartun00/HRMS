package kodlamaio.hrms.core.validators;

import kodlamaio.hrms.core.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.Candidate;

public class CandidateValidator {
	private Candidate candidate;
	private CandidateDao candidateDao;
	private MernisValidationService mernisValidationService;
	
	public CandidateValidator(Candidate candidate, CandidateDao candidateDao, MernisValidationService mernisValidationService) {
		super();
		this.candidate = candidate;
		this.candidateDao = candidateDao;
		this.mernisValidationService = mernisValidationService;
	}
	
	public Result isValid() {
		if (candidate.getFirstName().isEmpty())
            return new ErrorResult(EnglishMessages.CANDIDATE_ERROR_NAME_IS_BLANK);
		if (candidate.getLastName().isEmpty())
            return new ErrorResult(EnglishMessages.CANDIDATE_ERROR_SURNAME_IS_BLANK);
		if (candidate.getEmailAddress().isEmpty())
            return new ErrorResult(EnglishMessages.USER_ERROR_EMAIL_IS_BLANK);
		if (candidate.getPassword().isEmpty())
            return new ErrorResult(EnglishMessages.USER_ERROR_PASSWORD_IS_BLANK);
		if (candidate.getIdentificationNumber().isEmpty())
            return new ErrorResult(EnglishMessages.CANDIDATE_ERROR_IDENTITY_NUMBER_IS_BLANK);
		if (this.candidateDao.existsByEmailAddress(candidate.getEmailAddress()))
            return new ErrorResult(EnglishMessages.USER_ERROR_EMAIL_ALREADY_EXISTS);
		if (this.candidateDao.existsByIdentificationNumber(candidate.getIdentificationNumber()))
            return new ErrorResult(EnglishMessages.CANDIDATE_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS);
		
		
		if(!mernisValidationService.checkIfRealPerson(candidate))
			return new ErrorResult(EnglishMessages.CANDIDATE_NOT_VALID_PERSON);
		
		return new SuccessResult();
	}
	
	
}