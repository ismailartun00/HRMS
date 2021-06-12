package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface FieldService<T> {

	Result verifyData(T data);

	DataResult<List<T>> getAll();

}
