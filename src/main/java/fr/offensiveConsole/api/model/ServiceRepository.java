package fr.offensiveConsole.api.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.offensiveConsole.api.domain.Service;

@Repository
public interface ServiceRepository extends CrudRepository<Service,Long>{
	
	//Service findOneById(long id);
	//Iterable<Service> findAllByName(String name);
	
	


}
