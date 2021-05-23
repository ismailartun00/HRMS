package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="job_titles")
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Pattern(regexp = "[a-zA-Z]+?{5,}", message="Just use lower or upper letter.")
	@Column(name="title", nullable = false, length = 50)
	private String title;
}
