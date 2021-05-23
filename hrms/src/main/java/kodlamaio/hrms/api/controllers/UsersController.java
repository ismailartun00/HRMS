package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.ApiPaths;
import kodlamaio.hrms.entities.concretes.User;

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
	
	@PostMapping("/add")
	@ApiOperation(value = "User Add Operation", response = User.class)
	public Result add(@RequestBody User user) {
		
		return this.userService.add(user);
	}
	
	@PutMapping("/update-{id}")
	@ApiOperation(value = "User Update Operation", response = User.class)
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody User user){
		return this.userService.update(id, user);
	}
	
	@DeleteMapping("/delete-{id}")
	@ApiOperation(value = "User Delete Operation", response = User.class)
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.userService.delete(id);
	}
	
}