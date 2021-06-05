package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

import java.util.List;

import javax.validation.Valid;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.JobTitleCtrl.CTRL)
@Api(value = "Job Title APIs")
@RequiredArgsConstructor
public class JobTitlesController {
	
	private final JobTitleService jobTitleService;
	
	
	@GetMapping("/getall")
	@ApiOperation(value = "Job Title Get All Operation", response = JobTitle.class)
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Job Title Add Operation", response = JobTitle.class)
	public Result add(@RequestBody JobTitle jobTitle) {
		
		return this.jobTitleService.add(jobTitle);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Job Title Update Operation", response = JobTitle.class)
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody JobTitle jobTitle){
		return this.jobTitleService.update(id, jobTitle);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Job Title Delete Operation", response = JobTitle.class)
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.jobTitleService.delete(id);
	}

}
