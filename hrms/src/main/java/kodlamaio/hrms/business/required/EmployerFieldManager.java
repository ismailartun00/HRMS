package kodlamaio.hrms.business.required;

import java.util.List;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.EmployerDao;
import kodlamaio.hrms.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployerFieldManager implements FieldService<Employer> {

	private final EmployerDao employerDao;
	private final UserDao userDao;
	private final VerifyCodeService verifyCodeService;
	private final ConfirmEmployerService confirmEmployerService;

	@Override
	public Result verifyData(Employer employer) {
		String[] splitMail = employer.getEmailAddress().split("@");
		if (!splitMail[1].equals(employer.getWebAddress())) {
			return new ErrorResult(
					"Yalnızca Şirket Web Sitenizin Uzantısına Sahip Bir Mail Adresiyle Kayıt Olabilirsiniz");
		}
		if (this.userDao.existsByMail(employer.getEmailAddress())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (employer.getPassword().equals(employer.getPasswordRepeat()) == false) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.employerDao.save(employer);
		this.verifyCodeService.createVerifyCode(userDao.getOne(employer.getId()));
		this.confirmEmployerService.createConfirmEmployer(employer);
		this.verifyCodeService.sendMail(employer.getEmailAddress());
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Listeleme Başarılı");
	}
}
