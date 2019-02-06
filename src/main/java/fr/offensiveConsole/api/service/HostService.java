package fr.offensiveConsole.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.offensiveConsole.api.domain.Host;
import fr.offensiveConsole.api.model.HostRepository;
import fr.offensiveConsole.api.domain.Port;

@Service
public class HostService {
	
	@Autowired
	private HostRepository repo;
	
	public Iterable<Host> getAll() {
		return repo.findAll();
	}
	
	public Host findOneById(long id) {
		
		return repo.findOne(id);
	}
	public Host findOneByIp(String ip) {
		
		return repo.findOneHostByIp(ip);
		
	}
	
	public Host save(Host host) {
		if (host==null) {return null;}
		for (Port port : host.getPorts()) {
			port.setHost(host);
		}
		
		return repo.save(host);
	}
	
	public void deleteByIP(Long id) {
		if (id != null) {
			repo.delete(id);
		}
	}
	

}
