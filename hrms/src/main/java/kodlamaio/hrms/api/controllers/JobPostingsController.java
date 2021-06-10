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
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "JobPosting APIs")
@RequestMapping(ApiPaths.JobPostingCtrl.CTRL)
public class JobPostingsController {

	private final JobPostingService jobPostingService;

	@GetMapping("/getActive")
	@ApiOperation(value = "JobPosting Get Active Operation", response = JobPosting.class)
	DataResult<List<JobPostingDto>> findByIsActive() {
		return this.jobPostingService.findByIsActive();
	}

	@PostMapping("/add")
	@ApiOperation(value = "JobPosting Add Operation", response = JobPosting.class)
	Result add(@Valid @RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.add(jobPostingAddDto);
	}

	@GetMapping("/getActive/OrderByEndDate")
	@ApiOperation(value = "JobPosting Get Active - Order By End Date Operation", response = JobPosting.class)
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return this.jobPostingService.findByIsActiveOrderByClosedDate();
	}

	@GetMapping("/get/CompanyName")
	@ApiOperation(value = "JobPosting Get - Company Name Operation", response = JobPosting.class)
	DataResult<List<JobPostingDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName);
	}
}
