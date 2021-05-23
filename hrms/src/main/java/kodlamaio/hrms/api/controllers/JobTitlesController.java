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
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.ApiPaths;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping(ApiPaths.JobTitleCtrl.CTRL)
@Api(value = "Job Title APIs")
public class JobTitlesController {
	
	@Autowired
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
	
	@PutMapping("/update-{id}")
	@ApiOperation(value = "Job Title Update Operation", response = JobTitle.class)
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody JobTitle jobTitle){
		return this.jobTitleService.update(id, jobTitle);
	}
	
	@DeleteMapping("/delete-{id}")
	@ApiOperation(value = "Job Title Delete Operation", response = JobTitle.class)
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.jobTitleService.delete(id);
	}

}