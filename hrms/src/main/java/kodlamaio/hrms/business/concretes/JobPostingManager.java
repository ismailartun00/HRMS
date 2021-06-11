package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.converters.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.exceptions.NotFoundException;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingCreateDto;
import kodlamaio.hrms.entities.dtos.JobPostingUpdateDto;
import kodlamaio.hrms.entities.dtos.JobPostingViewDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPostingManager implements JobPostingService {

	private final JobPostingDao jobPostingDao;
	private final DtoConverterService dtoConverterService;

	@Override
	public Result add(JobPostingCreateDto jobPostingAddDto) {
		this.jobPostingDao.save((JobPosting) dtoConverterService.dtoClassConverter(jobPostingAddDto, JobPosting.class));
		return new SuccessResult("İş İlanı Eklendi");
	}

	@Override
	public Result update(int id, JobPostingUpdateDto jobPostingUpdateDto) {
		if(this.jobPostingDao.findById(id)!= null) {
			this.jobPostingDao.save((JobPosting) dtoConverterService.dtoClassConverter(jobPostingUpdateDto, JobPosting.class));
		return new SuccessResult("İş İlanı Güncellendi");
		}
		this.jobPostingDao.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return new ErrorResult(id + "'ye ait iş ilanı mevcut değildir.");
		
	}

	@Override
	public Result delete(JobPosting jobPosting) {
		this.jobPostingDao.delete(jobPosting);
		return new SuccessResult("Silme işlemi Tamamlandı");
	}

	@Override
	public DataResult<List<JobPostingViewDto>> findByIsActive() {
		return new SuccessDataResult<List<JobPostingViewDto>>(
				dtoConverterService.dtoConverter(jobPostingDao.findByIsActive(true), JobPostingViewDto.class),
				"Aktif İş İlanları Listelendi");
	}

	@Override
	public DataResult<List<JobPostingViewDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingViewDto>>(this.dtoConverterService.dtoConverter(
				this.jobPostingDao.findByIsActiveOrderByClosedDate(true), JobPostingViewDto.class), "Data Listelendi");
	}

	@Override
	public DataResult<List<JobPostingViewDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobPostingViewDto>>(this.dtoConverterService.dtoConverter(
				this.jobPostingDao.findByIsActiveAndEmployer_CompanyName(true, companyName), JobPostingViewDto.class),
				"Data Listelendi");
	}
}
