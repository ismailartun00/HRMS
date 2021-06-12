package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
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
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeCreateDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Resume APIs")
@RequestMapping(ApiPaths.ResumeCtrl.CTRL)
public class ResumesController {

	private final ResumeService resumeService;

	@GetMapping("/getall")
	@ApiOperation(value = "Resume Get All Operation", response = Resume.class)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.resumeService.getAll());
	}

	@GetMapping("/getByCandidateId")
	@ApiOperation(value = "Resume Get By Candidate Id Operation", response = Resume.class)
	public ResponseEntity<?> findAllByCandidateId(int id) {
		return ResponseEntity.ok(this.resumeService.findAllByCandidateId(id));
	}

	@PostMapping(value = "/add")
	@ApiOperation(value = "Resume Add Operation", response = Resume.class)
	public ResponseEntity<?> add(@Valid @RequestBody ResumeCreateDto resumeDto) {
		return ResponseEntity.ok(this.resumeService.add(resumeDto));
	}

	@PutMapping("/uploadImage")
	@ApiOperation(value = "Resume Upload Image Operation", response = Resume.class)
	public ResponseEntity<?> saveImage(@RequestBody MultipartFile file, @RequestParam int resumeId) {
		return ResponseEntity.ok(this.resumeService.saveImage(file, resumeId));
	}
}
