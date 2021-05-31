package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();
	DataResult<JobTitle> getById(int id);
	
	Result add(JobTitle jobPosition);
	Result update(JobTitle jobPosition);
	Result delete(JobTitle jobPosition);
}
