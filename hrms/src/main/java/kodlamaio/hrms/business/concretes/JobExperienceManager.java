package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.converters.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class JobExperienceManager implements JobExperienceService {

	private final JobExperienceDao jobExperienceDao;
	private final DtoConverterService dtoConverterService;

	@Override
	public Result add(JobExperienceDto jobExperienceDto) {
		jobExperienceDao
				.save((JobExperience) dtoConverterService.dtoClassConverter(jobExperienceDto, JobExperience.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public SuccessDataResult<List<JobExperienceDto>> getAll() {
		return new SuccessDataResult<List<JobExperienceDto>>(
				this.dtoConverterService.dtoConverter(this.jobExperienceDao.findAll(), JobExperienceDto.class),
				"Data Listelendi");
	}

	@Override
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return new SuccessDataResult<List<JobExperienceDto>>(this.dtoConverterService
				.dtoConverter(this.jobExperienceDao.findAllByResumeIdOrderByEndedDateDesc(id), JobExperienceDto.class),
				"Data Listelendi");
	}
}
