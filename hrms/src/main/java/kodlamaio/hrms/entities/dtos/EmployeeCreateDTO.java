package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeCreateDTO {

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
}
