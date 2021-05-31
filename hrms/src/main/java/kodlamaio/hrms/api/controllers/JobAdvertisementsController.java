package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementForAddDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Job Advertisement APIs")
@RequestMapping(ApiPaths.JobAdvertisementCtrl.CTRL)
public class JobAdvertisementsController {
	private final JobAdvertisementService jobAdvertisementService;
	
	
	@GetMapping("/getall")
	@ApiOperation(value = "Job Advertisement Get All Operation", response = JobAdvertisement.class)
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getActiveJobs")
	@ApiOperation(value = "Job Advertisement Get Job Is Active Operation", response = JobAdvertisement.class)
	public DataResult<List<JobAdvertisement>> getJobsIsActive(){
		return this.jobAdvertisementService.getJobsIsActive();
	}
	
	@GetMapping("/getActiveJobsOrdered")
	@ApiOperation(value = "Job Advertisement Get Job Is Active Ordered Publish Date Operation", response = JobAdvertisement.class)
	public DataResult<List<JobAdvertisement>> getActiveJobsOrdered(){
		return this.jobAdvertisementService.findByIsActiveTrueOrderPublishDate();
	}
	
	@GetMapping("/getActiveJobsByEmployer")
	@ApiOperation(value = "Job Advertisement Get Job Is Active Employer Company Name Operation", response = JobAdvertisement.class)
	public DataResult<List<JobAdvertisement>> getActiveJobsByEmployer_CompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.findByEmployer_CompanyName(companyName);
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "Job Advertisement Add Operation", response = JobAdvertisement.class)
	public Result add(@RequestBody JobAdvertisementForAddDto jobAdvertisementDto){
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}
	
	@PostMapping("/update")
	@ApiOperation(value = "Job Advertisement Update Operation", response = JobAdvertisement.class)
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	@ApiOperation(value = "Job Advertisement Delete Operation", response = JobAdvertisement.class)
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
}
