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
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@Api(value = "Language APIs")
@RequestMapping(ApiPaths.LanguageCtrl.CTRL)
public class LanguagesController {

	private final LanguageService languageService;

	@GetMapping("/getall")
	@ApiOperation(value = "Language Get All Operation", response = Language.class)
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.languageService.getAll());
	}

	@PostMapping("/add")
	@ApiOperation(value = "Language Add Operation", response = Language.class)
	public ResponseEntity<?> add(@Valid @RequestBody LanguageDto languageDto) {
		return ResponseEntity.ok(this.languageService.add(languageDto));
	}

}
