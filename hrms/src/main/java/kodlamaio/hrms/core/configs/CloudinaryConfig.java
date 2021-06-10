package kodlamaio.hrms.core.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.adapters.cloudinary.abstracts.CloudinaryService;
import kodlamaio.hrms.core.adapters.cloudinary.concretes.CloudinaryManager;

@Configuration
public class CloudinaryConfig {
	@Bean
	public Cloudinary cloudinaryUser() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dz4fiunqv", "api_key", "885774338775428", "api_secret",
				"cZa8AmuEyZskv1dKq2nXBf-E6EE"));
	}

	@Bean
	public CloudinaryService cloudinaryService() {
		return new CloudinaryManager(cloudinaryUser());
	}

}
