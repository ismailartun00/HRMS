package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobPositionManager implements JobPositionService {

	private final FieldService<JobPosition> controllerService;

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return controllerService.getAll();
	}

	@Override
	public Result add(JobPosition newJobPositions) {
		return controllerService.verifyData(newJobPositions);
	}

}
