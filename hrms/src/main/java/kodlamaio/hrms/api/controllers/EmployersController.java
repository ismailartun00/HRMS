package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Employer;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Employer APIs")
@RequestMapping(ApiPaths.EmployerCtrl.CTRL)
public class EmployersController {

	private final EmployerService employerService;
	
	@GetMapping("/getall")
	@ApiOperation(value = "Employer Get All Operation", response = Employer.class)
	public DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}

	
	@PostMapping("/add")
	@ApiOperation(value = "Employee Add Operation", response = Employer.class)
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
}
