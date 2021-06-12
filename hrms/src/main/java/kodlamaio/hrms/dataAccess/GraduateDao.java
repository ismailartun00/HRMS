package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Graduate;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface GraduateDao extends JpaRepository<Graduate, Integer> {

	boolean existsByDescription(String description);

}
