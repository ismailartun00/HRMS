package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.EmployeeConfirm;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "id")
@EqualsAndHashCode(callSuper = false)
public class Employee extends User {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private List<EmployeeConfirm> employeeConfirms;
<<<<<<< HEAD
	
	public Employee(String emailAddress, String password, String firstName, String lastName) {
		super(emailAddress, password);
		this.firstName = firstName;
		this.lastName = lastName;
	}
=======
>>>>>>> 55ddad10cf405556a31feeb6b053395040681794
}
