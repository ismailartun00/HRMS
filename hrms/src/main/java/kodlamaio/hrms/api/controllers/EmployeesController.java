package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

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
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employee;
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
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Employee Add Operation", response = Employee.class)
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
	
}