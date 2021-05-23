package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.User;

public interface UserService {
	DataResult<List<User>> getAll();
	Result add(User user);
	Result update(int id, User user);
	Result delete(int id);
}
