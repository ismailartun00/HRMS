package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.VerifyCode;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface VerifyCodeDao extends JpaRepository<VerifyCode, Integer> {

	VerifyCode getByVerifyCode(String Code);

	boolean existsByVerifyCode(String Code);

}
