package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobTitleFieldManager implements FieldService<JobPosition> {

	private final JobPositionDao jobPositionDao;

	@Override
	public Result verifyData(JobPosition jobPosition) {
		if (jobPositionDao.existsByPosition(jobPosition.getPosition())) {
			return new ErrorResult("Bu Pozisyon Daha Önce Kaydedildi");
		}

		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Kayıt Eklendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Listeleme Başarılı");
	}
}
