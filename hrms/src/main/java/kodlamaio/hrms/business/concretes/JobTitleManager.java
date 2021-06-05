package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobTitleManager implements JobTitleService {
	
	private final JobTitleDao jobTitleDao;


	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(), "Job Titles are Listed.");
	}


	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("Job Title is Added.");
	}
	
	@Override
	public Result update(int id, JobTitle jobTitle) {
		if(jobTitleDao.getOne(id) == null) {
			return new ErrorResult(jobTitle.getTitle() + " doesn't exist");
		}
		jobTitleDao.save(jobTitle);
		
		return new SuccessResult(jobTitle.getTitle() + " updated");
	}


	@Override
	public Result delete(int id) {		
		if(jobTitleDao.getOne(id) == null) {
			return new ErrorResult(id + " was not found");
		}
		jobTitleDao.deleteById(id);

		return new SuccessResult(id + " deleted");
	}

}
