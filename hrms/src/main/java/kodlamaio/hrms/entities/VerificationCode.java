package kodlamaio.hrms.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_codes")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","verificationCodeCandidate, verificationCodeEmployer"})
public class VerificationCode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "is_verified")
	private boolean isVerified;
	
	/*@OneToMany(mappedBy="verificationCode", fetch = FetchType.LAZY)
	private List<VerificationCodeCandidate> verificationCodeCandidates;
	
	@OneToMany(mappedBy="verificationCode", fetch = FetchType.LAZY)
	private List<VerificationCodeEmployer> verificationCodeEmployers;*/

}
