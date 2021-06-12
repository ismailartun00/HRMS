package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.ConfirmEmployerDao;
import kodlamaio.hrms.dataAccess.EmployerDao;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ConfirmEmployerManager implements ConfirmEmployerService {

	private final ConfirmEmployerDao confirmEmployerDao;
	private final EmployerDao employerDao;

	@Override
	public void createConfirmEmployer(Employer employer) {
		ConfirmEmployer cUser = new ConfirmEmployer();
		cUser.setEmployer(employer);
		cUser.setStaffUser(1);
		this.confirmEmployerDao.save(cUser);
	}

	@Override
	public Result confirmUser(String companyName) {
		if (!employerDao.existsByCompanyName(companyName)) {
			return new ErrorResult("Şirket Kaydı Bulunamadı");
		}

		if (employerDao.getByCompanyName(companyName).isUserConfirm()) {
			return new ErrorResult("Daha önce onaylanmış Şirket");
		}

		Employer employer = new Employer();
		ConfirmEmployer cUser = new ConfirmEmployer();
		employer = employerDao.getByCompanyName(companyName);
		employer.setUserConfirm(true);
		employerDao.save(employer);
		cUser = confirmEmployerDao.getByEmployer_Id(employer.getId());
		cUser.setConfirmed(true);
		LocalDate e = (LocalDate.now());
		cUser.setConfirmedDate(Date.valueOf(e));
		confirmEmployerDao.save(cUser);
		return new SuccessResult("Doğrulama Başarılı");
	}
}
