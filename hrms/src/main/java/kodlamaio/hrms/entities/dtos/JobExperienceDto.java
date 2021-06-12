package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
import javax.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {

	@JsonIgnore
	private int id;

	private int resumeId;

	private String companyName;

	@Past(message = "Başlangıç tarihi bugünden sonra olamaz")
	private Date startedDate;

	private Date endedDate;

	private int jobTitleId;

}
