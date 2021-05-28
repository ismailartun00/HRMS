package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class EmployerManager implements EmployerService {
	
	@Autowired
	private EmployerDao employerDao;


	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>("Employer are Listed", this.employerDao.findAll());
	}
	
	@Override
	public DataResult<Employer> getById(int id) {
		if (this.employerDao.findById(id).orElse(null) != null) {
			return new SuccessDataResult<Employer>("Belirtilen iş pozisyonu başarıyla bulundu.",
					this.employerDao.findById(id).get());
		} else {
			return new ErrorDataResult<Employer>("Belirtilen iş pozisyonu mevcut değildir.");
		}
	}


	@Override
	public Result add(Employer employer) {
		if (this.hasEmptyField(employer)) {
			return new ErrorResult("Tüm alanlar zorunludur.");
		} else {
			this.employerDao.save(employer);
			return new SuccessResult("İşveren başarıyla kaydedildi.");
		}
	}


	@Override
	public Result update(int id, Employer employer) {
		if(employerDao.getOne(id) == null) {
			return new ErrorResult("Employer Does not Exist");
		}
		employerDao.save(employer);
		return new SuccessResult("Employer is Updated");
	}
	
	@Override
	public Result delete(int id) {
		if(employerDao.getOne(id) == null) {
			return new ErrorResult("Id of Employer is Null");
		}
		employerDao.deleteById(id);
		return new SuccessResult("Employer is Deleted");
	}
	
	@Override
	public boolean existsEmployerByEmailAddress(String emailAddress) {
		return this.employerDao.existsEmployerByEmailAddress(emailAddress);
	}

	@Override
	public boolean hasEmptyField(Employer employer) {
		if (employer.getCompanyName().isEmpty() || employer.getWebAddress().isEmpty() || employer.getEmailAddress().isEmpty() || employer.getPassword().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
