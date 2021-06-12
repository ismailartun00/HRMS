package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class LanguageDto {

	@JsonIgnore
	private int id;

	private int resumeId;

	private String language;

	private char langLevel;

}
