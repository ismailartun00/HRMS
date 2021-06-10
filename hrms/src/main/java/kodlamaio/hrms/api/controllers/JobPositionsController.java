package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "JobPosition APIs")
@RequestMapping(ApiPaths.JobPositionCtrl.CTRL)
public class JobPositionsController {

	private final JobPositionService jobPositionsService;

	@GetMapping("/getall")
	@ApiOperation(value = "JobPosition Get All Operation", response = JobPosition.class)
	public DataResult<List<JobPosition>> getAll() {
		return this.jobPositionsService.getAll();
	}

	@PostMapping("/add")
	@ApiOperation(value = "JobPosition Add Operation", response = JobPosition.class)
	public Result add(@Valid @RequestBody JobPosition newJobPositions) {
		return this.jobPositionsService.add(newJobPositions);
	}
}
