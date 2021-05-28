package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name = "id")
public class Employee extends User {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    public Employee(int id, String emailAddress, String password, String firstName, String lastName) {
    	super(id, emailAddress, password);
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    
    public Employee(String emailAddress, String password, String firstName, String lastName) {
    	super(emailAddress, password);
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
}