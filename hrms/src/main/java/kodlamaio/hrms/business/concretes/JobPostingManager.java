package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.converters.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPostingManager implements JobPostingService {

	private final JobPostingDao jobPostingDao;
	private final DtoConverterService dtoConverterService;

	@Override
	public Result add(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save((JobPosting) dtoConverterService.dtoClassConverter(jobPostingAddDto, JobPosting.class));
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingDto>>(
				dtoConverterService.dtoConverter(jobPostingDao.findByIsActive(true), JobPostingDto.class),
				"Aktif İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>(this.dtoConverterService.dtoConverter(
				this.jobPostingDao.findByIsActiveOrderByClosedDate(true), JobPostingDto.class), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingDto>>(this.dtoConverterService.dtoConverter(
				this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingDto.class),
				"Data Listelendi");
	}
}
