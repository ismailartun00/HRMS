package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Graduate;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface GraduateService {

	DataResult<List<Graduate>> getAll();

	Result add(Graduate graduate);

}
