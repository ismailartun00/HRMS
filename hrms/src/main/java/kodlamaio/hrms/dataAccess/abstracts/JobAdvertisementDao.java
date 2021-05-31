package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {	
	List<JobAdvertisement> findByIsActiveTrueOrderByPublishDate();
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
	
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getIsActive();
}
