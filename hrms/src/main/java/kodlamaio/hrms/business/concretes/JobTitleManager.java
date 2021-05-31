package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validators.JobTitleValidator;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.JobTitle;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobTitleManager implements JobTitleService {
	private final JobTitleDao jobTitleDao;
	private JobTitleValidator jobTitleValidator;

	
	@Override
	public DataResult<List<JobTitle>> getAll() {
	
		return new SuccessDataResult<List<JobTitle>>
		(this.jobTitleDao.findAll(),EnglishMessages.JOB_TITLE_SUCCESS_DATA_LISTED);			
	}
	
	
	@Override
	public DataResult<JobTitle> getById(int id) {
		JobTitle jobTitle = jobTitleDao.findById(id);
		if(jobTitle == null)
			return new ErrorDataResult<JobTitle>();
		return new SuccessDataResult<JobTitle>(jobTitle);
	}
	
	
	@Override
	public Result add(JobTitle jobTitle) {
		jobTitleValidator = new JobTitleValidator(jobTitle, jobTitleDao);
		Result result = jobTitleValidator.isValid();
		if( result instanceof ErrorResult)
			return result;
			
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult(EnglishMessages.JOB_TITLE_SUCCESS_ADDED);
	}


	@Override
	public Result update(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job position updated.");
	}


	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult("Job position deleted.");
	}
}
