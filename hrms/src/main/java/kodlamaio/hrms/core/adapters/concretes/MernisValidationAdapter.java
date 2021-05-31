package kodlamaio.hrms.core.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.adapters.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisValidationAdapter implements MernisValidationService{

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
        boolean result=false;
        try {
            result=client.TCKimlikNoDogrula(
                        Long.valueOf(candidate.getIdentificationNumber()), 
                        candidate.getFirstName().toUpperCase(), 
                        candidate.getLastName().toUpperCase(), 
                        candidate.getBirthOfDate().getYear());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
	}

}