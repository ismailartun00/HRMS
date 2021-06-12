package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.ConfirmEmployer;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface ConfirmEmployerDao extends JpaRepository<ConfirmEmployer, Integer> {

	ConfirmEmployer getByEmployer_Id(int id);

	boolean existsByEmployer_Id(int id);
}
