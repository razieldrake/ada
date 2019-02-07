package fr.offensiveConsole.api.restController;

import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import fr.offensiveConsole.api.domain.CVE;
import fr.offensiveConsole.api.domain.Host;
import fr.offensiveConsole.api.service.HostService;
import fr.offensiveConsole.api.dto.CVEDTO;
import fr.offensiveConsole.api.dto.HostDTO;
import fr.offensiveConsole.api.dto.PortDTO;
import fr.offensiveConsole.api.dto.ServiceDTO;
import fr.offensiveConsole.api.domain.Port;
import fr.offensiveConsole.api.domain.Service;

@RestController
@RequestMapping(path="/hosts")
public class HostRestController {

	@Autowired
	HostService service;
	
	@GetMapping
	public ResponseEntity<Iterable<Host>> getAll(){
		
		return ResponseEntity.ok(service.getAll());
		/**
		 * On trouble for the return yu can use the clear function
		 * Iterable <Host> host = 	service.getAll();
		host.forEach(h->h.getPortsOnHost().clear());
		 */
	}
	@GetMapping(params= {"id_host"})
	public ResponseEntity<Host> getOneByID(@RequestParam(name = "id_host")Long id){
		return ResponseEntity.ok(service.findOneById(id));
	}
	
	@GetMapping("/{id_host}/ports")
	public ResponseEntity<Collection<fr.offensiveConsole.api.domain.Port>> getCvesForService(@PathVariable("id_host")Long id){
		
		Host host = service.findOneById(id);
		
		return ResponseEntity.ok(host.getPorts());
	}
	
	@PostMapping()
	public ResponseEntity<Void> create(@RequestBody HostDTO dto, UriComponentsBuilder ucb, Principal principal){
		Assert.notNull(dto,"A dto cannot be null");
		Host host = new Host(null, dto.getIp(), dto.getOs(), dto.isNew(), dto.getName());
		if (dto.getPorts()!= null) {
			for (PortDTO portdto : dto.getPorts()) {
				System.out.println("prout");
				Port port = new Port(portdto.getIdPort(), portdto.getStatus(), portdto.getProtocol());
				host.getPorts().add(port);
				port.setHost(host);
				if (portdto.getServices()!=null) {
					for (ServiceDTO servicedto : portdto.getServices()) {
						Service service = new Service((Long) null, servicedto.getNameService(), servicedto.getVersionService());
						port.getService().add(service);
						service.setort(port);
						if(servicedto.getCves()!=null) {
							for(CVEDTO cvedto : servicedto.getCves()) {
								CVE cve = new CVE(cvedto.getIdCVE(), cvedto.getBaseScore(), cvedto.getImpactScore(), cvedto.getVector(), cvedto.getAttackVector(), cvedto.getDescriptionCVE());
								service.getCve().add(cve);
								cve.setService(service);
							}
						}
					}
				}
			}
		}
		
		Host savedHost = service.save(host);
		URI location = ucb.path("/host/{id}").buildAndExpand(savedHost.getId()).toUri();
		return ResponseEntity.created(location).build();
		
	}
}
