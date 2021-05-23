package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class UserManager implements UserService {
	
	@Autowired
	private UserDao userDao;
	User userDb = new User();
	

	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Users are Listed");
	}


	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User is Added");
	}


	@Override
	public Result update(int id, User user) {
		userDb = userDao.getOne(id);
		if(userDb == null) {
			return new ErrorResult("User Does not Exist");
		}
		
		userDb.setId(user.getId());
		userDb.setEmail(user.getEmail());
		userDb.setPassword(user.getPassword());
		
		userDao.save(userDb);
		
		return new SuccessResult("User is Updated");
	}
	
	@Override
	public Result delete(int id) {
		if(userDb == null) {
			return new ErrorResult("Id of User is Null");
		}
		
		userDao.deleteById(id);

		return new SuccessResult("User is Deleted");
	}

}
