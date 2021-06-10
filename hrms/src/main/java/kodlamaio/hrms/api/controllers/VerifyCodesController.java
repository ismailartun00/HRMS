package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kodlamaio.hrms.business.abstracts.VerifyCodeService;
import kodlamaio.hrms.core.utilities.constants.ApiPaths;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerifyCode;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Api(value = "VerifyCode APIs")
@RequestMapping(ApiPaths.VerifyCodeCtrl.CTRL)
public class VerifyCodesController {

	private final VerifyCodeService verifyCodeService;

	@PutMapping("/{verifyCode}")
	@ApiOperation(value = "VerifyCode Update Operation", response = VerifyCode.class)
	public Result update(@PathVariable("verifyCode") String verifyCode) {
		return verifyCodeService.verifyUser(verifyCode);
	}
}
