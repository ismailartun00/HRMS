package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {

}
