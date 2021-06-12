package kodlamaio.hrms.entities.dtos;

import javax.validation.constraints.NotBlank;

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
public class TechnologyDto {

	@JsonIgnore
	private int id;

	private int resumeId;

	@NotBlank(message = "Teknoloji Açıklaması Boş Geçilemez")
	private String description;

}
