package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingCreateDto;
import kodlamaio.hrms.entities.dtos.JobPostingUpdateDto;
import kodlamaio.hrms.entities.dtos.JobPostingViewDto;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface JobPostingService {

	Result add(JobPostingCreateDto jobPostingAddDto);

	Result update(int id, JobPostingUpdateDto jobPostingUpdateDto);
	
	Result delete(JobPosting jobPosting);

	DataResult<List<JobPostingViewDto>> findByIsActive();

	DataResult<List<JobPostingViewDto>> findByIsActiveOrderByClosedDate();

	DataResult<List<JobPostingViewDto>> findByIsActiveAndEmployer_CompanyName(String companyName);

}
