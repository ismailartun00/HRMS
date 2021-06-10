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
import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Education APIs")
@RequestMapping(ApiPaths.EducationCtrl.CTRL)
public class EducationsController {

	private final EducationService educationService;

	@GetMapping("/getall")
	@ApiOperation(value = "Education Get All Operation", response = Education.class)
	public DataResult<List<EducationDto>> getAll() {
		return this.educationService.getAll();
	}

	@GetMapping("/getOrderByDate")
	@ApiOperation(value = "Education Get Order By Date Operation", response = Education.class)
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndedDateDesc(int id) {
		return this.educationService.findAllByResumeIdOrderByEndedDateDesc(id);
	}

	@PostMapping("/add")
	@ApiOperation(value = "Education Add Operation", response = Education.class)
	public Result add(@Valid @RequestBody EducationDto educationDto) {
		return this.educationService.add(educationDto);
	}
}
