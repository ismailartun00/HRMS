package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employer;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {

	Employer getByCompanyName(String companyName);

	boolean existsByCompanyName(String companyName);

}
