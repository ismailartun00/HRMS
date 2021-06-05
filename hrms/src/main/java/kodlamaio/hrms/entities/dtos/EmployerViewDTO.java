package kodlamaio.hrms.entities.dtos;

import java.io.Serializable;

import kodlamaio.hrms.entities.concretes.Employer;
import lombok.Data;

@Data
public class EmployerViewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private final String companyName;
	private final String webAddress;
	
	private EmployerViewDTO(String companyName, String webAddress) {
		this.companyName = companyName;
		this.webAddress = webAddress;
	}
	
	public static EmployerViewDTO of(Employer employer) {
		return new EmployerViewDTO(employer.getCompanyName(), employer.getWebAddress());
	}
}
