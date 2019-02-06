package fr.offensiveConsole.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.offensiveConsole.api.domain.CVE;
import fr.offensiveConsole.api.model.ServiceRepository;

@Service
public class ServiceService {
	
	@Autowired
	private ServiceRepository repo;
	
	public Iterable<fr.offensiveConsole.api.domain.Service> getAll(){
		return repo.findAll();
	}
	
	public fr.offensiveConsole.api.domain.Service findOneById(long id){
		return repo.findOne(id);
	}
	
	public Iterable<fr.offensiveConsole.api.domain.Service> findAllWithName(String name){
		
		return repo.findAllByName(name);
	}
	public fr.offensiveConsole.api.domain.Service save(fr.offensiveConsole.api.domain.Service service){
		
		for (CVE cve : service.getCve()) {
			cve.setService(service);
		}
		
		return repo.save(service);
	}

}
