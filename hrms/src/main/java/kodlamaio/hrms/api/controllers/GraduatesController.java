package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Graduate;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Graduate APIs")
@RequestMapping(ApiPaths.GraduateCtrl.CTRL)
public class GraduatesController {

	private final GraduateService graduateService;

	@GetMapping("/getall")
	@ApiOperation(value = "Graduate Get All Operation", response = Graduate.class)
	public DataResult<List<Graduate>> getAll() {
		return this.graduateService.getAll();
	}

	@PostMapping("/add")
	@ApiOperation(value = "Graduate Add Operation", response = Graduate.class)
	public Result add(@Valid @RequestBody Graduate graduate) {
		return this.graduateService.add(graduate);
	}
}
