package kodlamaio.hrms.business.concretes;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private JobTitleService jobTitleService;
	private EmployerService employerService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,
			CityService cityService,
			JobTitleService jobTitleService,
			EmployerService employerService) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.jobTitleService = jobTitleService;
		this.employerService = employerService;
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Job advertisements listed.");
	}


	@Override
	public Result add(JobAdvertisementForAddDto jobAdvertisementDto) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement(
				jobAdvertisementDto.getDescription(),
				jobAdvertisementDto.getQuantityPosition(),
				jobAdvertisementDto.getMinSalary(),
				jobAdvertisementDto.getMaxSalary(),
				new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				jobAdvertisementDto.getDeadline(),
				jobAdvertisementDto.isActive()
				);
		jobAdvertisement.setCity(cityService.getById(jobAdvertisementDto.getCityId()).getData());
		jobAdvertisement.setJobTitle(jobTitleService.getById(jobAdvertisementDto.getJobId()).getData());
		jobAdvertisement.setEmployer(employerService.getByCompanyName(jobAdvertisementDto.getCompanyName()).getData());
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement added.");
	}


	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement updated.");
	}


	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Job advertisement deleted.");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getJobsIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getIsActive()
				);
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderPublishDate() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueOrderByPublishDate());
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

}
