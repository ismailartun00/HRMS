package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployerCreateDTO {

	private String emailAddress;
	private String password;
	private String companyName;
	private String webAddress;
}
