package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.FieldService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {

	private final FieldService<Employer> controllerService;

	@Override
	public DataResult<List<Employer>> getAll() {
		return controllerService.getAll();
	}

	@Override
	public Result add(Employer employer) {
		return this.controllerService.verifyData(employer);
	}

}
