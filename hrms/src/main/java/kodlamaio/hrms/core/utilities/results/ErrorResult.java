package kodlamaio.hrms.core.utilities.results;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public class ErrorResult extends Result {

	public ErrorResult() {
		super(false);

	}

	public ErrorResult(String message) {
		super(false, message);

	}

}
