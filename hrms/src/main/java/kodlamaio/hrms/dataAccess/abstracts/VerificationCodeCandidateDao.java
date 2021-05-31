package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.VerificationCodeCandidate;

public interface VerificationCodeCandidateDao extends JpaRepository<VerificationCodeCandidate, Integer> {

}
