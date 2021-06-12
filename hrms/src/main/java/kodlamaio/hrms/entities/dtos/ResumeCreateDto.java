package kodlamaio.hrms.entities.dtos;

import java.sql.Date;
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
@AllArgsConstructor
@NoArgsConstructor
public class ResumeCreateDto {

	@JsonProperty(access = Access.READ_ONLY)
	private int id;

	private int candidateId;

	private String githubLink;

	private String linkedLink;

	private String photo;

	private String description;

	private Date createdDate;

	private Date updatedDate;

}
