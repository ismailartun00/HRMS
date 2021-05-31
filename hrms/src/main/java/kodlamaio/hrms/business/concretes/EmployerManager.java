package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validators.EmployerValidator;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.Employer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {
	
	private final EmployerDao employerDao;
	private EmployerValidator employerValidator;
	
	
	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"Employers listed.");
	}

	@Override
	public DataResult<Employer> getByCompanyName(String companyName) {

		return new SuccessDataResult<Employer>(this.employerDao.findByCompanyName(companyName));
	}

	@Override
	public Result add(Employer employer) {

		this.employerValidator = new EmployerValidator(employer, employerDao);
		Result result = employerValidator.isValid();
		if( result instanceof ErrorResult)
			return result;
	
		
		this.employerDao.save(employer);
		return new SuccessResult(EnglishMessages.EMPLOYER_SUCCESS_ADDED);
	}

}
