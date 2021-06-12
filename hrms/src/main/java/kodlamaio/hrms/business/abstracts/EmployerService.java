package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface EmployerService {

	DataResult<List<Employer>> getAll();

	Result add(Employer employer);

}
