package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.exceptions.NotFoundException;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeViewDTO;
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
	public Employee getByEmailAddress(String emailAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
