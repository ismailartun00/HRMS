package kodlamaio.hrms.core.utilities.results;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {

		super(data, true, message);

	}

	public ErrorDataResult(T data) {

		super(data, true);
	}

	public ErrorDataResult(String message) {

		super(null, true, message);

	}

	public ErrorDataResult() {

		super(null, true);

	}

}
