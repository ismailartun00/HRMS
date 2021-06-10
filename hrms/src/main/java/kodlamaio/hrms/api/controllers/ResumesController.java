package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeGetDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Resume APIs")
@RequestMapping(ApiPaths.ResumeCtrl.CTRL)
public class ResumesController {

	private final ResumeService resumeService;

	@GetMapping("/getall")
	@ApiOperation(value = "Resume Get All Operation", response = Resume.class)
	public DataResult<List<ResumeGetDto>> getAll() {
		return this.resumeService.getAll();
	}

	@GetMapping("/getByCandidateId")
	@ApiOperation(value = "Resume Get By Candidate Id Operation", response = Resume.class)
	public DataResult<List<ResumeGetDto>> findAllByCandidateId(int id) {
		return this.resumeService.findAllByCandidateId(id);
	}

	@PostMapping(value = "/add")
	@ApiOperation(value = "Resume Add Operation", response = Resume.class)
	public Result add(@Valid @RequestBody ResumeAddDto resumeDto) {
		return this.resumeService.add(resumeDto);
	}

	@PutMapping("/uploadImage")
	@ApiOperation(value = "Resume Upload Image Operation", response = Resume.class)
	public Result saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
		return this.resumeService.saveImage(file, resumeId);
	}
}
