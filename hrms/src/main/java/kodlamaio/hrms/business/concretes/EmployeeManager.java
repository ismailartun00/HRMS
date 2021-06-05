package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
<<<<<<< HEAD
import kodlamaio.hrms.core.exceptions.NotFoundException;
=======
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
<<<<<<< HEAD
import kodlamaio.hrms.entities.dtos.EmployeeCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeViewDTO;
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {
	
	private final EmployeeDao employeeDao;

	@Override
	public List<EmployeeViewDTO> getAll() {
		
		return employeeDao.findAll().stream().map(EmployeeViewDTO::of).collect(Collectors.toList());
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)	
	public EmployeeViewDTO add(EmployeeCreateDTO employeeCreateDto) {
		
		final Employee employee = employeeDao.save(new Employee(employeeCreateDto.getEmailAddress(), 
				employeeCreateDto.getPassword(), employeeCreateDto.getFirstName(), employeeCreateDto.getLastName()));
		
		return EmployeeViewDTO.of(employee);
	}

<<<<<<< HEAD
	@Override
	public EmployeeViewDTO update(int id, EmployeeUpdateDTO employeeUpdateDto) {
		
		final Employee employee = employeeDao.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		employee.setFirstName(employeeUpdateDto.getFirstName());
		employee.setLastName(employeeUpdateDto.getLastName());
		
		final Employee updatedEmployee = employeeDao.save(employee);
		return EmployeeViewDTO.of(updatedEmployee);
	}

	@Override
	public void delete(int id) {
		final Employee employee = employeeDao.findById(id).orElseThrow(() ->new NotFoundException("Not Found Exception"));
		employeeDao.deleteById(employee.getId());
	}

	@Override
=======
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
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	public Result getByEmailAddress(String emailAddress) {

		return new SuccessResult(emailAddress + " found");
	}

}
