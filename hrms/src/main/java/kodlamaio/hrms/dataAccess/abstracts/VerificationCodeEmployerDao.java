package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.VerificationCodeEmployer;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer, Integer> {

}
