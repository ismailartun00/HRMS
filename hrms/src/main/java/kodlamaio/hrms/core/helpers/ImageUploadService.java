package kodlamaio.hrms.core.helpers;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface ImageUploadService {
	DataResult<Map<String,String>> uploadImage(MultipartFile image);
}
