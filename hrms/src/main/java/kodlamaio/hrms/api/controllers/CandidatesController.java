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
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@Api(value = "Candidate APIs")
@RequestMapping(ApiPaths.CandidateCtrl.CTRL)
public class CandidatesController {

	private final CandidateService candidatesService;

	@GetMapping("/getall")
	@ApiOperation(value = "Candidate Get All Operation", response = Candidate.class)
	public DataResult<List<Candidate>> getAll() {
		return this.candidatesService.getAll();
	}

	@PostMapping("/add")
	@ApiOperation(value = "Candidate Add Operation", response = Candidate.class)
	public Result newCandidate(@Valid @RequestBody Candidate newCandidate) {
		return candidatesService.add(newCandidate);
	}

}
