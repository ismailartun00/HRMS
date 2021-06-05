package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = false)
public class Employer extends User{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "web_address")
	private String webAddress;
	
	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	private List<VerificationCodeEmployer> verificationCodeEmployers;
	
	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
	
	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	private List<EmployerPhone> employerPhones;
	
	@OneToMany(mappedBy = "employer", fetch = FetchType.LAZY)
	private List<EmployeeConfirmEmployer> employeeConfirmEmployers;
}
