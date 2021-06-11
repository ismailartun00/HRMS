package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeCreateDto;
import kodlamaio.hrms.entities.dtos.ResumeViewDto;

public interface ResumeService {

	Result add(ResumeCreateDto resumeDto);

	DataResult<List<ResumeViewDto>> getAll();

	DataResult<List<ResumeViewDto>> findAllByCandidateId(int id);

	Result saveImage(MultipartFile file, int resumeId);
}
