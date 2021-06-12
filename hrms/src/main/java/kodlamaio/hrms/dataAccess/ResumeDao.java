package kodlamaio.hrms.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Resume;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface ResumeDao extends JpaRepository<Resume, Integer> {

	List<Resume> findAllByCandidateId(int id);

}
