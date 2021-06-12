package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@Api(value = "JobExperience APIs")
@RequestMapping(ApiPaths.JobExperienceCtrl.CTRL)
public class JobExperiencesController {

	private final JobExperienceService jobExperienceService;

	@GetMapping("/getall")
	@ApiOperation(value = "JobExperience Get All Operation", response = JobExperience.class)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.jobExperienceService.getAll());
	}

	@GetMapping("/getOrderByDate")
	@ApiOperation(value = "JobExperience Get Order By Date Operation", response = JobExperience.class)
	public ResponseEntity<?> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return ResponseEntity.ok(this.jobExperienceService.findAllByResumeIdOrderByEndedDateDesc(id));
	}

	@PostMapping("/add")
	@ApiOperation(value = "JobExperience Add Operation", response = JobExperience.class)
	public ResponseEntity<?> add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return ResponseEntity.ok(this.jobExperienceService.add(jobExperienceDto));
	}
}
