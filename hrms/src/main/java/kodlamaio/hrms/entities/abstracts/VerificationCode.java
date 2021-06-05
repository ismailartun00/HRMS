package kodlamaio.hrms.entities.abstracts;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="verification_codes")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class VerificationCode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@NotBlank
	@Column(name = "code")
	private String code;
	
	@NotNull
	@Column(name = "is_verified")
	private boolean isVerified;
	
	public VerificationCode(String code, boolean isVerified) {
		this.code = code;
		this.isVerified = isVerified;
	}

}
