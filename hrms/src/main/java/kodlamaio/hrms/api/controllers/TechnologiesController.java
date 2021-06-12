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
import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Technology APIs")
@RequestMapping(ApiPaths.TechnologyCtrl.CTRL)
public class TechnologiesController {

	private final TechnologyService technologyService;

	@GetMapping("/getall")
	@ApiOperation(value = "Technology Get All Operation", response = Technology.class)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.technologyService.getAll());
	}

	@PostMapping("/add")
	@ApiOperation(value = "Technology Add Operation", response = Technology.class)
	public ResponseEntity<?> add(@Valid @RequestBody TechnologyDto technologyDto) {
		return ResponseEntity.ok(this.technologyService.add(technologyDto));
	}
}