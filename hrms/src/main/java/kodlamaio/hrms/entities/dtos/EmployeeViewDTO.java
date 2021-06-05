package kodlamaio.hrms.entities.dtos;

import java.io.Serializable;

import kodlamaio.hrms.entities.concretes.Employee;
import lombok.Getter;

@Getter
public final class EmployeeViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String firstName;
	private final String lastName;
	
	private EmployeeViewDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static EmployeeViewDTO of(Employee employee) {
		return new EmployeeViewDTO(employee.getFirstName(), employee.getLastName());
	}
	
}
