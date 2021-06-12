package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();

	Result add(JobPosition newJobPositions);

}
