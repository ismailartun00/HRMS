package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.exceptions.NotFoundException;
import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployerUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployerViewDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {
	
	private final EmployerDao employerDao;

	@Override
	public List<EmployerViewDTO> getAll() {

		return employerDao.findAll().stream().map(EmployerViewDTO::of).collect(Collectors.toList());
	}

	@Override
	public EmployerViewDTO add(EmployerCreateDTO employerCreateDto) {
		final Employer employer = employerDao.save(new Employer(employerCreateDto.getEmailAddress(),
				employerCreateDto.getPassword(), employerCreateDto.getCompanyName(), employerCreateDto.getPassword()));
		
		return EmployerViewDTO.of(employer);
	}

	@Override
	public EmployerViewDTO update(int id, EmployerUpdateDTO employerUpdateDto) {
		final Employer employer = employerDao.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		employer.setCompanyName(employerUpdateDto.getCompanyName());
		employer.setWebAddress(employerUpdateDto.getWebAddress());
		
		final Employer updatedEmployer = employerDao.save(employer);
		return EmployerViewDTO.of(updatedEmployer);
	}

	@Override
	public void delete(int id) {
		final Employer employer = employerDao.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		employerDao.deleteById(employer.getId());
	}

	@Override
	public Result getByEmailAddress(String emailAddress) {
		
		return new SuccessResult(emailAddress + " found");
	}

	@Override
	public Result getByCompanyName(String companyName) {

		return new SuccessResult(companyName + " found");
	}

	@Override
	public Result getByWebAddress(String webAddress) {
		
		return new SuccessResult(webAddress + " found");
	}


}
