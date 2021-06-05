package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CandidateUpdateDTO {

	private String firstName;
	private String lastName;
	private String identificationNumber;
	private LocalDate birthOfDate;
}
