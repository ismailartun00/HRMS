package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
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
public class JobPostingCreateDto {

	@JsonIgnore
	private int id;

	private int employerId;

	private int jobPositionId;

	private int openPositionNumber;

	private int minSalary;

	private int maxSalary;

	private int cityId;

	private Date createdDate;

	private Date closedDate;

	private String description;

}
