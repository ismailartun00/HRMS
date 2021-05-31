package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.JobTitle;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Job Title APIs")
@RequestMapping(ApiPaths.JobTitleCtrl.CTRL)
public class JobTitlesController {
	private JobTitleService jobTitleService;

	
	@GetMapping("/getall")
	@ApiOperation(value = "Job Title Get All Operation", response = JobTitle.class)
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "Job Title Add Operation", response = JobTitle.class)
	public Result add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "Job Title Update Operation", response = JobTitle.class)
	public Result update(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.update(jobTitle);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value = "Job Title Delete Operation", response = JobTitle.class)
	public Result delete(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.delete(jobTitle);
	}
	
}
