package kodlamaio.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Education;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> findAllByResumeIdOrderByEndedDateDesc(int id);

}
