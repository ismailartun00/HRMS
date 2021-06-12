package kodlamaio.hrms.business.required;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.adapters.mernis.concretes.VerifyApiService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.CandidateDao;
import kodlamaio.hrms.dataAccess.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CandidateFieldManager implements FieldService<Candidate> {

	private final CandidateDao candidateDao;
	private final UserDao userDao;
	private final VerifyApiService<Candidate> verifyApiService;
	private final VerifyCodeService verifyCodeService;

	@Override
	public Result verifyData(Candidate candidate) {

		if (!this.verifyApiService.ApiControl(candidate)) {
			return new ErrorResult("Mernis Kimlik Doğrulaması Başarısız Oldu");
		}
		if (this.userDao.existsByMail(candidate.getEmailAddress())) {
			return new ErrorResult("Mail Adresi Daha Önce Kullanıldı");
		}
		if (candidateDao.existsByNationalIdentity(candidate.getNationalIdentity())) {
			return new ErrorResult("TC Kimlik Numarası Daha Önce Kullanıldı");
		}
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Şifreler Uyuşmuyor");
		}
		this.candidateDao.save(candidate);
		this.verifyCodeService.createVerifyCode(userDao.getOne(candidate.getId()));
		this.verifyCodeService.sendMail(candidate.getEmailAddress());
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Listeleme Başarılı");
	}
}
