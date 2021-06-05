package kodlamaio.hrms.api.controllers;

import java.util.List;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
import javax.validation.Valid;

>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
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
<<<<<<< HEAD
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployerUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployerViewDTO;
=======
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
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
<<<<<<< HEAD
	public ResponseEntity<?> add(@RequestBody EmployerCreateDTO employerCreateDto) {
		employerService.add(employerCreateDto);
		return ResponseEntity.ok(new SuccessResult("Employer Created"));
=======
	public Result add(@RequestBody Employer employer) {
		
		return this.employerService.add(employer);
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Employee Update Operation", response = Employer.class)
<<<<<<< HEAD
	public ResponseEntity<?> update (@PathVariable(value = "id", required = true) int id, @RequestBody EmployerUpdateDTO employerUpdateDto){
		final EmployerViewDTO employerViewDto = employerService.update(id, employerUpdateDto);
		return ResponseEntity.ok(employerViewDto);
=======
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody Employer employer){
		return this.employerService.update(id, employer);
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Employee Delete Operation", response = Employer.class)
<<<<<<< HEAD
	public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) int id){
		employerService.delete(id);
		return ResponseEntity.ok(new SuccessResult("Employer Deleted"));
=======
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.employerService.delete(id);
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	}
	
}