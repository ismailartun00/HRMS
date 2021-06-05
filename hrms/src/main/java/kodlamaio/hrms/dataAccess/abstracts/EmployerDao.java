package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Employer;

@Repository
public interface EmployerDao extends JpaRepository<Employer, Integer> {
	Employer getByEmailAddress(String emailAddress);
	Employer getByCompanyName(String companyName);
	Employer getByWebAddress(String webAddress);
	
}
