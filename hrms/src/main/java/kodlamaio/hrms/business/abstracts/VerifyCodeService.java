package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface VerifyCodeService {

	String createVerifyCode(User user);

	void sendMail(String mail);

	Result verifyUser(String code);

}
