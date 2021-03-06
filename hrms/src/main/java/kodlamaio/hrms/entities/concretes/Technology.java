package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resume_techs")
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;

	@NotBlank(message = "Boş Geçilemez")
	@Column(name = "description")
	private String description;

	@Column(name = "created_date")
	private Date createdDate;

}
