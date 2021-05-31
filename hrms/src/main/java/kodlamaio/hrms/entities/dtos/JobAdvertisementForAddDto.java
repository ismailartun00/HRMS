package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForAddDto {
	private int jobId;
	private int cityId;
	private String description;
	private String companyName;
	private int quantityPosition;
	private double minSalary;
	private double maxSalary;
	private LocalDate deadline;
	private boolean isActive;
}
