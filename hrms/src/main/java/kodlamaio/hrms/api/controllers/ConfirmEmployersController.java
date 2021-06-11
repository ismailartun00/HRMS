package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.ConfirmEmployerService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.ConfirmEmployer;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "ConfirmEmployer APIs")
@RequestMapping(ApiPaths.ConfirmEmployerCtrl.CTRL)
public class ConfirmEmployersController {

	private final ConfirmEmployerService confirmEmployerService;

	@PutMapping("/{companyName}")
	@ApiOperation(value = "ConfirmEmployer Update Operation", response = ConfirmEmployer.class)
	public ResponseEntity<?> update(@PathVariable("companyName") String companyName) {

		return ResponseEntity.ok(confirmEmployerService.confirmUser(companyName));
	}
}
