package fr.offensiveConsole.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.offensiveConsole.api.domain.Port;
import fr.offensiveConsole.api.model.PortRepository;

@Service
public class PortService {
	
	@Autowired
	private PortRepository repo;
	
	public Iterable<Port> getAll(){
		return repo.findAll();
	}
	
	public Port findPortById(int id) {
		return repo.findOne(id);
	}
	
	/*Iterable<Port> findPortByProtocol(String protocol){
		return repo.findPortByProtocol(protocol);
	}
	
	Iterable<Port> findPortByStatus(String status){
		
		return repo.findPortByStatus(status);
	}*/
	
	public Port save(Port port) {
		
		for (fr.offensiveConsole.api.domain.Service service : port.getService()) {
			service.setort(port);			
		}
		
		return repo.save(port);
		
	}
	
	public void deleteById(int id) {
		
		repo.delete(id);
	}
	
	

}
