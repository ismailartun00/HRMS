package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

	private final JobAdvertisementDao jobAdversimentDao;
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdversimentDao.findAll(),"Tüm İş İlanları Listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdversimentDao.getByIsActiveTrue(), "Aktif İş İlanları Listelendi" );
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueOrderByPublishDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdversimentDao.getByIsActiveTrueOrderByPublishDate(),"Aktif İş İlanları Sıralanarak Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActiveTrueAndEmployer_CompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>> (this.jobAdversimentDao.getByIsActiveTrueAndEmployer_CompanyName(companyName), "Aktif iş ilanları şirketler için sıralandı.");
	}
}
