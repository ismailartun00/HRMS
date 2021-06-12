package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingCreateDto;
import kodlamaio.hrms.entities.dtos.JobPostingUpdateDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "JobPosting APIs")
@RequestMapping(ApiPaths.JobPostingCtrl.CTRL)
public class JobPostingsController {

	private final JobPostingService jobPostingService;

	@GetMapping("/getActive")
	@ApiOperation(value = "JobPosting Get Active Operation", response = JobPosting.class)
	public ResponseEntity<?> findByIsActive() {
		return ResponseEntity.ok(this.jobPostingService.findByIsActive());
	}

	@PostMapping("/add")
	@ApiOperation(value = "JobPosting Add Operation", response = JobPosting.class)
	public ResponseEntity<?> add(@Valid @RequestBody JobPostingCreateDto jobPostingAddDto) {
		return ResponseEntity.ok(this.jobPostingService.add(jobPostingAddDto));
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "JobPosting Update Operation", response = JobPosting.class)
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody  JobPostingUpdateDto jobPostingUpdateDto) {
		return ResponseEntity.ok(this.jobPostingService.update(id, jobPostingUpdateDto));
	}

	@GetMapping("/getActive/OrderByEndDate")
	@ApiOperation(value = "JobPosting Get Active - Order By End Date Operation", response = JobPosting.class)
	public ResponseEntity<?> findByIsActiveOrderByClosedDate() {
		return ResponseEntity.ok(this.jobPostingService.findByIsActiveOrderByClosedDate());
	}

	@GetMapping("/get/CompanyName")
	@ApiOperation(value = "JobPosting Get - Company Name Operation", response = JobPosting.class)
	public ResponseEntity<?> findByIsActiveAndEmployer_CompanyName(String companyName) {
		return ResponseEntity.ok(this.jobPostingService.findByIsActiveAndEmployer_CompanyName(companyName));
	}
}
