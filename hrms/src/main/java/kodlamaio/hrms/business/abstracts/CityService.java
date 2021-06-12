package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface CityService {

	DataResult<List<City>> getAll();

}
