package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Email(message="Please enter a valid mail!")
	//@Pattern(regexp = "[a-zA-Z][\\w-]{1,20}@\\w{2,20}\\.\\w{2,3}$", message="The mail is not valid.")
	private String email;
	
	@Column(name="password", nullable = false, length = 50)
	private String password;
	
}
