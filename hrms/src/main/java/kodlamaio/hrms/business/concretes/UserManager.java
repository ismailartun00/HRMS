package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService{
	
	private final UserDao userDao;

	@Override
	public DataResult<List<User>> getAll() {

		return new SuccessDataResult<List<User>>
		(this.userDao.findAll(),EnglishMessages.USER_SUCCESS_DATA_LISTED);
	}

}
