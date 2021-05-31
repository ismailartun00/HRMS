package kodlamaio.hrms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_codes_candidates")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = true)
public class VerificationCodeCandidate extends VerificationCode {

	private static final long serialVersionUID = 1L;
	
	/*@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="id")
	private VerificationCode verificationCode;*/
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="candidate_id", insertable=false, updatable=false)
	private Candidate candidate;

}