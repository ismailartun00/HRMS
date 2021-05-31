package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.Employee;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Employee APIs")
@RequestMapping(ApiPaths.EmployeeCtrl.CTRL)
public class EmployeesController {

	private final EmployeeService employeeService;

	
	@GetMapping("/getall")
	@ApiOperation(value = "Employee Get All Operation", response = Employee.class)
	public DataResult<List<Employee>> getAll(){
		return this.employeeService.getAll();
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "Employee Add Operation", response = Employee.class)
	public Result add(@RequestBody Employee employee) {
		return this.employeeService.add(employee);
	}
}
