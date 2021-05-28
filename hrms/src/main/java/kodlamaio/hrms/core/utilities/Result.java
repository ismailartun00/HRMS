package kodlamaio.hrms.core.utilities;

import lombok.NoArgsConstructor;

@NoArgsConstructor
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

	public boolean getSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
}