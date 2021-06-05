package kodlamaio.hrms.entities.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.Data;

@Data
public class CandidateViewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String firstName;
	private final String lastName;
	private final String identificationNumber;
	private final LocalDate birthOfDate;

	private CandidateViewDTO(String firstName, String lastName, String identificationNumber, LocalDate birthOfDate) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.identificationNumber = identificationNumber;
			this.birthOfDate = birthOfDate;
		}

	public static CandidateViewDTO of(Candidate candidate) {
		return new CandidateViewDTO(candidate.getFirstName(), candidate.getLastName(), candidate.getIdentificationNumber(), candidate.getBirthOfDate());
	}
}
