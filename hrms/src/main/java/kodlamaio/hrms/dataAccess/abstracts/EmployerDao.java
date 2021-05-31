package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	boolean existsByEmailAddress(String emailAddress);
	Employer findByCompanyName(String companyName);
}
