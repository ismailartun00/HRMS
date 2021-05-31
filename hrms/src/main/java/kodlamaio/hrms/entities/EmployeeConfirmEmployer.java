package kodlamaio.hrms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee_confirms_employers")
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = true)
public class EmployeeConfirmEmployer extends EmployeeConfirm{
	
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="id")
	private EmployeeConfirm employeeConfirms;*/

	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="employer_id", insertable=false, updatable=false)
	private Employer employer;
}
