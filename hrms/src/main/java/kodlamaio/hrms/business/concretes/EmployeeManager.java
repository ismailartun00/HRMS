package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.Employee;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
	
	private final EmployeeDao employeeDao;

	@Override
	public DataResult<List<Employee>> getAll() {

		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(),EnglishMessages.EMPLOYEE_SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(Employee employee) {

		this.employeeDao.save(employee);
		return new SuccessResult(EnglishMessages.EMPLOYEE_SUCCESS_ADDED);
	}

}
