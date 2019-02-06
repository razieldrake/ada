package fr.offensiveConsole.api.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.offensiveConsole.api.domain.Host;

@Repository
public interface HostRepository extends CrudRepository<Host,Long> {
	
	Iterable<Host> findAllByIpHost(String ipaddr);
	Host findOneHostByIp(String ip);
	

}
