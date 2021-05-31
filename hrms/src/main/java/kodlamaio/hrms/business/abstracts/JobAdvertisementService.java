package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisementForAddDto jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getJobsIsActive();
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderPublishDate();
	
	DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName);
}