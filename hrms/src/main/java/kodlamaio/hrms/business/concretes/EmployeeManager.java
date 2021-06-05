package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
	
	private final EmployeeDao employeeDao;

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>> (this.employeeDao.findAll(), EnglishMessages.EMPLOYEE_SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(Employee employee) {
		if(employeeDao.getByEmailAddress(employee.getEmailAddress()) != null) {
			return new ErrorResult(employee.getFirstName() + " could not be added." + employee.getFirstName() + "'s informations has already been defined.");
		}
		if(employee.getPassword().isEmpty()) {
			return new ErrorResult(employee.getFirstName() + "'s password can't be empty.");
		}
		this.employeeDao.save(employee);
		return new SuccessResult(employee.getFirstName() + " added successfully");
	}

	@Override
	public Result update(int id, Employee employee) {
		if(employeeDao.getOne(id) == null) {
			return new ErrorResult(employee.getFirstName() + " doesn't exist");
		}
		employeeDao.save(employee);
		return new SuccessResult(employee.getFirstName() + " updated");
	}

	@Override
	public Result delete(int id) {
		if(employeeDao.getOne(id) == null) {
			return new ErrorResult(id+ " was not found");
		}
		employeeDao.deleteById(id);
		return new SuccessResult(id + " deleted");
	}

	@Override
	public Result getByEmailAddress(String emailAddress) {

		return new SuccessResult(emailAddress + " found");
	}

}
