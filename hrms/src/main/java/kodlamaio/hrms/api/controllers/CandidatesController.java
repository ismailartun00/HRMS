package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
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
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.Candidate;
<<<<<<< HEAD
import kodlamaio.hrms.entities.dtos.CandidateCreateDTO;
import kodlamaio.hrms.entities.dtos.CandidateUpdateDTO;
import kodlamaio.hrms.entities.dtos.CandidateViewDTO;
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.CandidateCtrl.CTRL)
@Api(value = "Candidate APIs")
@RequiredArgsConstructor
public class CandidatesController {
	
	private final CandidateService candidateService;
	
	@GetMapping("/getall")
	@ApiOperation(value = "Candidate Get All Operation", response = Candidate.class)
	public ResponseEntity<?> getAll(){
		final List<CandidateViewDTO> candidates = candidateService.getAll();
		return ResponseEntity.ok(candidates);
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Candidate Add Operation", response = Candidate.class)
<<<<<<< HEAD
	public ResponseEntity<?> add( @RequestBody CandidateCreateDTO candidateCreateDto) {
		candidateService.add(candidateCreateDto);
		return ResponseEntity.ok(new SuccessResult("Candidate Created"));
	}

	
	@PutMapping("/{id}")
	@ApiOperation(value = "Candidate Update Operation", response = Candidate.class)
	public ResponseEntity<?> update (@PathVariable(value = "id", required = true) int id, @RequestBody CandidateUpdateDTO candidateUpdateDto){
		final CandidateViewDTO candidateViewDto = candidateService.update(id, candidateUpdateDto);
		return ResponseEntity.ok(candidateViewDto);
=======
	public Result add( @RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	}

	
	@PutMapping("/{id}")
	@ApiOperation(value = "Candidate Update Operation", response = Candidate.class)
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody Candidate candidate){
		return this.candidateService.update(id, candidate);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Candidate Delete Operation", response = Candidate.class)
<<<<<<< HEAD
	public ResponseEntity<?> delete(@PathVariable(value = "id", required = true) int id){
		candidateService.delete(id);
		return ResponseEntity.ok(new SuccessResult("Candidate Deleted"));
=======
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.candidateService.delete(id);
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
	}
	
}