package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployerUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployerViewDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiPaths.EmployerCtrl.CTRL)
@Api(value = "Employer APIs")
public class EmployersController {
	
	private final EmployerService employerService;
	
	
	@GetMapping("/getall")
	@ApiOperation(value = "Employer Get All Operation", response = Employer.class)
	public ResponseEntity<?> getAll(){
		final List<EmployerViewDTO> employers = employerService.getAll();
		return ResponseEntity.ok(employers);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Employee Add Operation", response = Employer.class)
	public ResponseEntity<?> add(@RequestBody EmployerCreateDTO employerCreateDto) {
		employerService.add(employerCreateDto);
		return ResponseEntity.ok(new SuccessResult("Employer Created"));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Employee Update Operation", response = Employer.class)
	public ResponseEntity<?> update (@PathVariable(value = "id", required = true) int id, @RequestBody EmployerUpdateDTO employerUpdateDto){
		final EmployerViewDTO employerViewDto = employerService.update(id, employerUpdateDto);
		return ResponseEntity.ok(employerViewDto);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Employee Delete Operation", response = Employer.class)
	public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) int id){
		employerService.delete(id);
		return ResponseEntity.ok(new SuccessResult("Employer Deleted"));
	}
	
}