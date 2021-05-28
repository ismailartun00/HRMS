package kodlamaio.hrms.core.utilities;

public class SuccessDataResult<T> extends DataResult<T> {
	
	public SuccessDataResult() {
		super(true, null);
	}
	
	public SuccessDataResult(T data) {
		super(true, data);
	}
	
	public SuccessDataResult(String message, T data) {
		super(true, message, data);
	}
	
	public SuccessDataResult(String message) {
		super(true, message, null);
	}
	
}