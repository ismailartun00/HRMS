package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class UserManager implements UserService {
	
	@Autowired
	private UserDao userDao;
	User userDb = new User();
	

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>("Users are Listed", this.userDao.findAll());
	}


	@Override
	public DataResult<User> getById(int id) {
		if (this.userDao.findById(id).orElse(null) != null ) {
			return new SuccessDataResult<User>("The id already existed", this.userDao.findById(id).get());
		} else {
			return new ErrorDataResult<User>("The id did not exist.");
		}
	}

}
