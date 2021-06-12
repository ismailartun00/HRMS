package kodlamaio.hrms.core.converters.dtoConverter.abstracts;

import java.util.List;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
public interface DtoConverterService {

	<S, T> List<T> dtoConverter(List<S> s, Class<T> targetClass);

	public <T> Object dtoClassConverter(Object source, Class<T> baseClass);

}
