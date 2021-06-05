package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(ApiPaths.JobAdvertisementCtrl.CTRL)
@Api(value = "JobAdvertisement APIs")
@RequiredArgsConstructor
public class JobAdvertisementsController {

	private final JobAdvertisementService jobAdvertisementService;

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByIsActive")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return this.jobAdvertisementService.getByIsActiveTrue();
	}
	
	@GetMapping("/getByIsActiveOrdered")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByPublishDate() {
		return this.jobAdvertisementService.getByIsActiveTrueOrderByPublishDate();
	}
	
	@GetMapping("/getByIsActiveEmployerCompanyName")
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(@RequestParam String companyName){
		return this.jobAdvertisementService.getByIsActiveTrueAndEmployer_CompanyName(companyName);
	}

}