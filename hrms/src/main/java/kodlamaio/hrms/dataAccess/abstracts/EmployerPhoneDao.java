package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.EmployerPhone;

public interface EmployerPhoneDao extends JpaRepository<EmployerPhone, Integer> {

}
