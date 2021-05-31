package kodlamaio.hrms.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","candidate, employee, employer"})
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="email_address", nullable = false, unique = true)
	private String emailAddress;
	
	@Column(name="password", nullable = false, length = 50)
	private String password;
	
	/*@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Candidate> candidates;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Employee> employees;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Employer> employers;*/


}