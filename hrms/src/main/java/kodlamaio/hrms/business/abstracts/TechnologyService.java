package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.TechnologyDto;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface TechnologyService {

	Result add(TechnologyDto technologyDto);

	DataResult<List<TechnologyDto>> getAll();

}
