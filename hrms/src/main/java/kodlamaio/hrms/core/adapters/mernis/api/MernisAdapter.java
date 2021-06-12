package kodlamaio.hrms.core.adapters.mernis.api;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapters.mernis.concretes.VerifyApiService;
import kodlamaio.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

/**
 * @author İSMAİL ARTUN
 * @since 1.0
 */
@Service
public class MernisAdapter implements VerifyApiService<Candidate> {

	@Override
	public boolean ApiControl(Candidate candidate) {
		KPSPublicSoapProxy kpsPublic;
		try {
			kpsPublic = new KPSPublicSoapProxy();
			@SuppressWarnings("deprecation")
			boolean durum = kpsPublic.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity()),
					candidate.getName().toUpperCase(), candidate.getSurname().toUpperCase(),
					candidate.getBirthOfDate().getYear());
			return durum;
		} catch (RemoteException | NumberFormatException e1) {
			e1.printStackTrace();
		}
		return false;
	}

}
