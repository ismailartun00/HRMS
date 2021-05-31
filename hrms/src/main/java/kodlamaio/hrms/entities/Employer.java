package kodlamaio.hrms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","verificationCodeEmployers, employerPhones, employeeConfirmsEmployers, jobAdvertisements"})
public class Employer extends User{

	private static final long serialVersionUID = 1L;
	
	/*@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="id")
	private User user;*/

	@Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "web_address", nullable = false, unique = true)
    private String webAddress;
    
    @OneToMany(mappedBy="employer", fetch = FetchType.LAZY)
	private List<VerificationCodeEmployer> verificationCodeEmployers;
    
    @OneToMany(mappedBy="employer", fetch = FetchType.LAZY)
	private List<EmployerPhone> employerPhones;
    
    @OneToMany(mappedBy="employer", fetch = FetchType.LAZY)
	private List<EmployeeConfirmEmployer> employeeConfirmsEmployers;
    
    @OneToMany(mappedBy="employer", fetch = FetchType.LAZY)
	private List<JobAdvertisement> jobAdvertisements;
    
    
    
    

}
