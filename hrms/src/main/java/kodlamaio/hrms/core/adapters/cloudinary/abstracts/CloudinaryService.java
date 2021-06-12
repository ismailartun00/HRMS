package kodlamaio.hrms.core.adapters.cloudinary.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface CloudinaryService {

	DataResult<?> save(MultipartFile file);

}
