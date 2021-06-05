package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

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
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.CandidateCtrl.CTRL)
@Api(value = "Candidate APIs")
@RequiredArgsConstructor
public class CandidatesController {
	
	private final CandidateService candidateService;
	
	@GetMapping("/getall")
	@ApiOperation(value = "Candidate Get All Operation", response = Candidate.class)
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/")
	@ApiOperation(value = "Candidate Add Operation", response = Candidate.class)
	public Result add( @RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}

	
	@PutMapping("/{id}")
	@ApiOperation(value = "Candidate Update Operation", response = Candidate.class)
	public Result update (@PathVariable(value = "id", required = true) int id, @Valid @RequestBody Candidate candidate){
		return this.candidateService.update(id, candidate);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Candidate Delete Operation", response = Candidate.class)
	public Result delete(@PathVariable(value = "id", required = true) int id){
		return this.candidateService.delete(id);
	}
	
}