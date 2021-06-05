package kodlamaio.hrms.entities.abstracts;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import kodlamaio.hrms.entities.concretes.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee_confirms")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EmployeeConfirm implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	private Employee employee;
	
	@NotNull
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	public EmployeeConfirm(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
}
