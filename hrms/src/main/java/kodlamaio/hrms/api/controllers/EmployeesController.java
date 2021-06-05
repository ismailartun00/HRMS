package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.EmployeeService;
<<<<<<< HEAD
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeCreateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeUpdateDTO;
import kodlamaio.hrms.entities.dtos.EmployeeViewDTO;
=======
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.EmployeeCtrl.CTRL)
@Api(value = "Employee APIs")
@RequiredArgsConstructor
public class EmployeesController {
	
	private final EmployeeService employeeService;
	
	
	@GetMapping("/getall")
	@ApiOperation(value = "Employee Get All Operation", response = Employee.class)
	public ResponseEntity<?> getAll(){
		final List<EmployeeViewDTO> employees = employeeService.getAll();
		return ResponseEntity.ok(employees);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Employee Add Operation", response = Employee.class)
<<<<<<< HEAD
	public ResponseEntity<?> add(@Valid @RequestBody EmployeeCreateDTO employeeCreateDto) {
		employeeService.add(employeeCreateDto);
		return ResponseEntity.ok(new SuccessResult("Employee Created"));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Employee Update Operation", response = Employee.class)
	public ResponseEntity<?> update (@PathVariable(value = "id", required = true) int id, @RequestBody EmployeeUpdateDTO employeeUpdateDto){
		final EmployeeViewDTO employeeViewDto = employeeService.update(id, employeeUpdateDto);
		return ResponseEntity.ok(employeeViewDto);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Employee Delete Operation", response = Employee.class)
	public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) int id){
		employeeService.delete(id);
		return ResponseEntity.ok(new SuccessResult("Employee Deleted"));
	}
	
=======
	public Result add(@RequestBody Employee employee) {
		
		return this.employeeService.add(employee);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Employee Update Operation", response = Employee.class)
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody Employee employee){
		return this.employeeService.update(id, employee);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Employee Delete Operation", response = Employee.class)
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.employeeService.delete(id);
	}
	
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
}