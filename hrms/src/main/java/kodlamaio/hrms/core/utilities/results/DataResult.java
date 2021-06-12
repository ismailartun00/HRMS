package kodlamaio.hrms.core.utilities.results;

import lombok.Getter;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Getter
public class DataResult<T> extends Result {

	private T data;

	public DataResult(T data, boolean success, String message) {
		super(success, message);
		this.data = data;

	}

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;

	}

}
