package kodlamaio.hrms.entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","verificationCodeCandidates"})
public class Candidate extends User{	
	
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="id")
	private User user;*/

	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(name="identification_number", nullable = false, unique = true)
	private String identificationNumber;
	
	@Column(name="birth_date", nullable = false)
	private LocalDate  birthOfDate;
	
	@OneToMany(mappedBy="candidate", fetch = FetchType.LAZY)
	private List<VerificationCodeCandidate> verificationCodeCandidates;
	
}
