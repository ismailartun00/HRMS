package kodlamaio.hrms.api.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CandidateService {
	
	public boolean mernisValidate(String identificationNumber ,String firstName, String lastName, int birthOfDate) {
		return true;
	}

    @Override
    public boolean checkIfRealPerson(Candidate candidate) {

    	System.out.println("x");
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		var result = true;
		
		try {
			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentificationNumber()), 
					candidate.getFirstName().toUpperCase(new Locale("tr")), 
					candidate.getLastName().toUpperCase(new Locale("tr")),candidate.getBirthOfDate().getYear());
			} catch (NumberFormatException e) {
				System.out.println("Lütfen kimlik numaranızı sayı formatında giriniz.");
			} catch (RemoteException e) {
				e.printStackTrace();
		}
		
		if(result) {
			System.out.println("Kimlik doğrulaması başarılı.");
		}else {
			System.out.println("Kimlik doğrulaması başarısız.");
			result = false;
		}
		
		return result;

    }




}
