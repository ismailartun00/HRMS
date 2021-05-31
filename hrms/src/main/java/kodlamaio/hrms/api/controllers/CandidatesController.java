package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.Candidate;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Candidate APIs")
@RequestMapping(ApiPaths.CandidateCtrl.CTRL)
public class CandidatesController {
	
	private CandidateService candidateService;

	@GetMapping("/getall")
	@ApiOperation(value = "Candidate Get All Operation", response = Candidate.class)
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@GetMapping("/getByIdentity")
	@ApiOperation(value = "Candidate Get By Identification Number Operation", response = Candidate.class)
	public DataResult<Candidate> getByIdentificationNumber(String identificationNumber){
		return this.candidateService.findByIdentificationNumber(identificationNumber);
	}
	
	@PostMapping("/add")
	@ApiOperation(value = "Candidate Add Operation", response = Candidate.class)
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	
}
