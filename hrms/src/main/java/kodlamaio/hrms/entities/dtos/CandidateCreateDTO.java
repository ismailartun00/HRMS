package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateCreateDTO {

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private String identificationNumber;
	private LocalDate birthOfDate;
}
