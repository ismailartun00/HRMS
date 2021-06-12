package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class CityManager implements CityService {

	private final CityDao cityDao;

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(), "Data Listelendi");
	}

}
