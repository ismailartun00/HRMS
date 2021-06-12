package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.Graduate;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Graduate APIs")
@RequestMapping(ApiPaths.GraduateCtrl.CTRL)
public class GraduatesController {

	private final GraduateService graduateService;

	@GetMapping("/getall")
	@ApiOperation(value = "Graduate Get All Operation", response = Graduate.class)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.graduateService.getAll());
	}

	@PostMapping("/add")
	@ApiOperation(value = "Graduate Add Operation", response = Graduate.class)
	public ResponseEntity<?> add(@Valid @RequestBody Graduate graduate) {
		return ResponseEntity.ok(this.graduateService.add(graduate));
	}
}
