package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.abstracts.User;

public interface UserService {
	DataResult<List<User>> getAll();
	DataResult<User> getById(int id);
}
