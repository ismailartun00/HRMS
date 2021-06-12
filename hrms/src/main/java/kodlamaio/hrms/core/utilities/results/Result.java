package kodlamaio.hrms.core.utilities.results;

import lombok.Getter;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Getter
public class Result {

	private boolean success;
	private String message;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

}
