package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResumeManager implements ResumeService {
	
	private final ResumeDao resumeDao;

	@Override
	public DataResult<List<Resume>> getAll() {
		Sort sort = Sort.by(Sort.Direction.DESC,"finishDate");
		return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(sort),"Job Experience Are Listed");
	}

	@Override
	public DataResult<Resume> add(Resume resume) {
		if (resume.isAvailable()) {
			return new SuccessDataResult<Resume>("İşten Çıkış Tarihinizi Boş Geçebilirsiniz.");
		}
		return new SuccessDataResult<>(this.resumeDao.save(resume));
	}

	@Override
	public DataResult<List<Resume>> getByIsAvailableTrueOrderByFinishDate() {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getByIsAvailableTrueOrderByFinishDate(), "Devam Ediyor");
	}
}
