package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "Employer APIs")
@RequestMapping(ApiPaths.EmployerCtrl.CTRL)
public class EmployersController {

	private final EmployerService employerService;

	@GetMapping("/getall")
	@ApiOperation(value = "Employer Get All Operation", response = Employer.class)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.employerService.getAll());
	}

	@PostMapping("/add")
	@ApiOperation(value = "Employer Add Operation", response = Employer.class)
	public ResponseEntity<?> newEmployer(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(employerService.add(employer));
	}
}
