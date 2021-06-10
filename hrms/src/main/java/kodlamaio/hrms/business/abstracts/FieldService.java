package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface FieldService<T> {

	Result verifyData(T data);

	DataResult<List<T>> getAll();

}
