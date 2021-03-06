package kodlamaio.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import kodlamaio.hrms.entities.concretes.JobPosting;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {

	List<JobPosting> findByIsActive(boolean status);

	List<JobPosting> findByIsActiveOrderByClosedDate(boolean status);

	List<JobPosting> findByIsActiveAndEmployer_CompanyName(boolean status, String companyName);

}
