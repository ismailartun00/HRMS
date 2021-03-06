package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.adapters.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrms.core.converters.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeCreateDto;
import kodlamaio.hrms.entities.dtos.ResumeViewDto;
import lombok.RequiredArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class ResumeManager implements ResumeService {

	private final ResumeDao resumeDao;
	private final CloudinaryService cloudinaryService;
	private final DtoConverterService dtoConverterService;

	@Override
	public Result add(ResumeCreateDto resumeDto) {
//		if (resume.getLanguages() != null) {
//			resume.getLanguages().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getEducation() != null) {
//			resume.getEducation().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getTechnologies() != null) {
//			resume.getTechnologies().forEach(lang -> lang.setResume(resume));
//		}
//		if (resume.getJobExperiences() != null) {
//			resume.getJobExperiences().forEach(lang -> lang.setResume(resume));
//		}

		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<ResumeViewDto>> getAll() {
		return new SuccessDataResult<List<ResumeViewDto>>(
				dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeViewDto.class), "Data Listelendi");
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {

		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<ResumeViewDto>> findAllByCandidateId(int id) {
		return new SuccessDataResult<List<ResumeViewDto>>(
				dtoConverterService.dtoConverter(resumeDao.findAllByCandidateId(id), ResumeViewDto.class),
				"Data Listelendi");
	}
}
