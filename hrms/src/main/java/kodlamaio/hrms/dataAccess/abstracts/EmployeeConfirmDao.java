package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.EmployeeConfirm;

public interface EmployeeConfirmDao extends JpaRepository<EmployeeConfirm, Integer> {

}
