package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer> {

}
