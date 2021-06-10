package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {

	Result add(JobPostingAddDto jobPostingAddDto);

	Result delete(JobPosting jobPosting);

	DataResult<List<JobPostingDto>> findByIsActive();

	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate();

	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName);

}
