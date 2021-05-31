package kodlamaio.hrms.core.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kodlamaio.hrms.core.utilities.constants.EnglishMessages;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.Employer;

public class EmployerValidator {
	private Employer employer;
	private EmployerDao employerDao;
	
	public EmployerValidator(Employer employer, EmployerDao employerDao) {
		super();
		this.employer = employer;
		this.employerDao = employerDao;
	}
	
	public Result isValid() {
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(employer.getEmailAddress());
		
		
		if (employer.getCompanyName().isEmpty())
            return new ErrorResult(EnglishMessages.EMPLOYER_ERROR_COMPANY_NAME_IS_BLANK);
        if (employer.getWebAddress().isEmpty())
            return new ErrorResult(EnglishMessages.EMPLOYER_ERROR_WEBSITE_IS_BLANK);
        if (employer.getEmailAddress().isEmpty())
            return new ErrorResult(EnglishMessages.USER_ERROR_EMAIL_IS_BLANK);
        if (employer.getPassword().isEmpty())
            return new ErrorResult(EnglishMessages.USER_ERROR_PASSWORD_IS_BLANK);
        if (!matcher.matches())
            return new ErrorResult(EnglishMessages.USER_ERROR_EMAIL_IS_NOT_VALID);
        if (this.employerDao.existsByEmailAddress(employer.getEmailAddress()))
            return new ErrorResult(EnglishMessages.USER_ERROR_EMAIL_ALREADY_EXISTS);
        
        return new SuccessResult();
	}
	
}