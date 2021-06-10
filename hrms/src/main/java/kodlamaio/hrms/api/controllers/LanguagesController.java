package kodlamaio.hrms.api.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "Language APIs")
@RequestMapping(ApiPaths.LanguageCtrl.CTRL)
public class LanguagesController {

	private final LanguageService languageService;

	@GetMapping("/getall")
	@ApiOperation(value = "Language Get All Operation", response = Language.class)
	public DataResult<List<LanguageDto>> getAll() {
		return this.languageService.getAll();
	}

	@PostMapping("/add")
	@ApiOperation(value = "Language Add Operation", response = Language.class)
	public Result add(@Valid @RequestBody LanguageDto languageDto) {
		return this.languageService.add(languageDto);
	}

}
