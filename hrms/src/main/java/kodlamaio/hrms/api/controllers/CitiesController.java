package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.City;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "City APIs")
@RequestMapping(ApiPaths.CityCtrl.CTRL)
public class CitiesController {

	private final CityService cityService;

	@GetMapping("/getall")
	@ApiOperation(value = "City Get All Operation", response = City.class)
	public DataResult<List<City>> getAll() {
		return cityService.getAll();
	}

}
