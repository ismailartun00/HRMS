package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.User;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	boolean existsByMail(String mail);

}
