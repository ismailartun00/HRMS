package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ApiPaths;
import kodlamaio.hrms.entities.abstracts.User;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = "User APIs")
public class UsersController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getall")
	@ApiOperation(value = "User Get All Operation", response = User.class)
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "User Get By Id Operation", response = User.class)
	public DataResult<User> getById(@PathVariable(value = "id", required = true) int id) {
		return userService.getById(id);
	}
	
}