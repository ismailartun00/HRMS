package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "User APIs")
@RequestMapping(ApiPaths.UserCtrl.CTRL)
public class UsersController {

	private final UserService userService;

	
	@GetMapping("/getall")
	@ApiOperation(value = "User Get All Operation", response = User.class)
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
}
