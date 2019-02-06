package fr.offensiveConsole.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.offensiveConsole.api.domain.CVE;
import fr.offensiveConsole.api.model.CveRepository;

@Service
public class CVEService {

	@Autowired
	private CveRepository repo;
	
	public Iterable<CVE> getAll(){
		
		return repo.findAll();
	}
	
	public CVE getAllByName(String name){
		
		return repo.findOne(name);
	}
	
	public CVE save(CVE cve) {
		
		return repo.save(cve);
	}
	
	public void deleteByID(String cve) {
		if(cve!=null) {
			repo.delete(cve);
		}
		
	}
	public void deleteByObject(CVE cve) {
		if (cve != null) {
			repo.delete(cve);
		}
	}
	
}
