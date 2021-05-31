package kodlamaio.hrms.entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="employer_id", insertable=false, updatable=false)
	private Employer employer;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="job_id", insertable=false, updatable=false)
	private JobTitle jobTitle;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="city_id", insertable=false, updatable=false)
	private City city;
	
	@Column(name = "description", nullable = false)
    private String description;
    
    @Column(name = "quantity_position", nullable = false)
    private int quantityPosition;
    
    @Column(name = "min_salary")
    private double minSalary;
    
    @Column(name = "max_salary")
    private double maxSalary;
    
    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;
    
    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;
    
    @Column(name = "is_active", nullable = false)
    private boolean isActive;	
    
    public JobAdvertisement(String description, int quantityPosition, double minSalary, double maxSalary, LocalDate publishDate, LocalDate deadline, boolean isActive) {
		super();
		this.description = description;
		this.quantityPosition = quantityPosition;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.publishDate = publishDate;
		this.deadline = deadline;
		this.isActive = isActive;
	}
	
}
