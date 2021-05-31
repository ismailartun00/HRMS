package kodlamaio.hrms.core.validators;

import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.JobTitle;

public class JobTitleValidator {
	
	private JobTitle jobTitle;
	private JobTitleDao jobTitleDao;
	
	public JobTitleValidator(JobTitle jobTitle, JobTitleDao jobTitleDao) {
		super();
		this.jobTitle = jobTitle;
		this.jobTitleDao = jobTitleDao;
	}
	
	public Result isValid() {
		
		if(this.jobTitleDao.existsByTitle(jobTitle.getTitle()))
			return new ErrorResult(EnglishMessages.JOB_TITLE_ERROR_ALREADY_EXISTS);
		
		return new SuccessResult();
	}
	
}
