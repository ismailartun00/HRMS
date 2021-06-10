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
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "JobExperience APIs")
@RequestMapping(ApiPaths.JobExperienceCtrl.CTRL)
public class JobExperiencesController {

	private final JobExperienceService jobExperienceService;

	@GetMapping("/getall")
	@ApiOperation(value = "JobExperience Get All Operation", response = JobExperience.class)
	public DataResult<List<JobExperienceDto>> getAll() {
		return this.jobExperienceService.getAll();
	}

	@GetMapping("/getOrderByDate")
	@ApiOperation(value = "JobExperience Get Order By Date Operation", response = JobExperience.class)
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return this.jobExperienceService.findAllByResumeIdOrderByEndedDateDesc(id);
	}

	@PostMapping("/add")
	@ApiOperation(value = "JobExperience Add Operation", response = JobExperience.class)
	public Result add(@Valid @RequestBody JobExperienceDto jobExperienceDto) {
		return this.jobExperienceService.add(jobExperienceDto);
	}
}
