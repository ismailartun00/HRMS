package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.City;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "City APIs")
@RequestMapping(ApiPaths.CityCtrl.CTRL)
public class CitiesController {
	private final CityService cityService;
	
	
	@GetMapping("/getall")
	@ApiOperation(value = "City Get All Operation", response = City.class)
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("getById")
	@ApiOperation(value = "City Get By Id Operation", response = City.class)
	public DataResult<City> getById(@RequestParam int id){
		return cityService.getById(id);
	}
}
