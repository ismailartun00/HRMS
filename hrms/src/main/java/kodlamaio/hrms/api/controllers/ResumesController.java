package kodlamaio.hrms.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.utilities.constants.ApiPaths;

import io.swagger.annotations.Api;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.entities.concretes.Resume;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(ApiPaths.ResumeCtrl.CTRL)
@Api(value = "JobExperience APIs")
@RequiredArgsConstructor
public class ResumesController {
	
    private final ResumeService resumeService;

	
	  @GetMapping("/getall")
	    public ResponseEntity<?> getAll(){
	        var result = this.resumeService.getAll();
	        if (!result.isSuccess()){
	            return ResponseEntity.badRequest().body(result);
	        }
	        return ResponseEntity.ok(result);
	    }
	  @PostMapping("/add")
	    public ResponseEntity<?> add(@RequestBody Resume resume){
		  
	        var result = this.resumeService.add(resume);
	        if (!result.isSuccess()){
	            return ResponseEntity.badRequest().body(result);
	        }
	        return ResponseEntity.ok(result);
	    }
	
	

}