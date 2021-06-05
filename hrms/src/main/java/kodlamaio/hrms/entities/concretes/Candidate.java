package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
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
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = false)
public class Candidate extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "birth_date")
	private LocalDate birthOfDate;

	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private List<VerificationCodeCandidate> verificationCodeCandidates;
	
	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private List<Resume> resumes;
<<<<<<< HEAD
	
	public Candidate(String emailAddress, String password, String firstName, String lastName, String identificationNumber, LocalDate birthOfDate) {
		super(emailAddress, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
		this.birthOfDate = birthOfDate;
	}
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
}
