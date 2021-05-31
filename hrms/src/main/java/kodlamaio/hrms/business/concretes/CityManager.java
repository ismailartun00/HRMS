package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.City;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CityManager implements CityService {
	
	private final CityDao cityDao;

	@Override
	public DataResult<List<City>> getAll() {

		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {

		return new SuccessDataResult<City>(this.cityDao.findById(id), "City getted.");
	}

}