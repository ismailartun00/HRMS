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
<<<<<<< HEAD
import kodlamaio.hrms.entities.dtos.EmployerCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployerUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployerViewDTO;
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {
	
	private final EmployerDao employerDao;

	@Override
	public List<EmployerViewDTO> getAll() {

<<<<<<< HEAD
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
=======
		return new SuccessDataResult<List<Employer>> (this.employerDao.findAll(), EnglishMessages.EMPLOYER_SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(Employer employer) {
		if(employerDao.getByEmailAddress(employer.getEmailAddress()) != null || employerDao.getByCompanyName(employer.getCompanyName()) != null
				|| employerDao.getByWebAddress(employer.getWebAddress()) != null) {
			return new ErrorResult(employer.getCompanyName() + " could not be added." + employer.getCompanyName() + "'s informations has already been defined.");
		}
		if(employer.getPassword().isEmpty()) {
			return new ErrorResult(employer.getCompanyName() + "'s password can't be empty.");
		}
		this.employerDao.save(employer);
		return new SuccessResult(employer.getCompanyName() + " added successfully");
	}

	@Override
	public Result update(int id, Employer employer) {
		if(employerDao.getOne(id) == null) {
			return new ErrorResult(employer.getCompanyName() + " doesn't exist");
		}
		employerDao.save(employer);
		return new SuccessResult(employer.getCompanyName() + " updated");
	}

	@Override
	public Result delete(int id) {
		if(employerDao.getOne(id) == null) {
			return new ErrorResult(id+ " was not found");
		}
		employerDao.deleteById(id);
		return new SuccessResult(id + " deleted");
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	}

	@Override
	public Result getByEmailAddress(String emailAddress) {
<<<<<<< HEAD
		
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

=======
		
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

>>>>>>> 55ddad10cf405556a31feeb6b053395040681794

}
