package fr.offensiveConsole.api.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.offensiveConsole.api.domain.Port;

@Repository
public interface PortRepository extends CrudRepository<Port,Integer>{
	
	Iterable<Port> findPortByProtocol(String proto);
	Iterable<Port> findPortByStatus(String status);
	Port findOneById(int id);
	
	
	

}
