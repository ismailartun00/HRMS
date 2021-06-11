package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CandidateManager implements CandidateService {

	private final FieldService<Candidate> controllerService;

	@Override
	public DataResult<List<Candidate>> getAll() {
		return this.controllerService.getAll();
	}

	@Override
	public Result add(Candidate candidate) {
		return this.controllerService.verifyData(candidate);
	}

}
