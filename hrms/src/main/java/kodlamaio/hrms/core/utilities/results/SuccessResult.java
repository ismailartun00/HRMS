package kodlamaio.hrms.core.utilities.results;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public class SuccessResult extends Result {

	public SuccessResult() {
		super(true);

	}

	public SuccessResult(String message) {
		super(true, message);

	}
}
