package fr.offensiveConsole.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.offensiveConsole.api.domain.Service;

@JsonInclude(value=Include.NON_EMPTY)
public class PortDTO {
	
	private int idPort;
	
	private String protocol;
	
	private String status;
	
	private ServiceDTO[] services;

	public int getIdPort() {
		return idPort;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getStatus() {
		return status;
	}

	public ServiceDTO[] getServices() {
		return services;
	}

	public void setIdPort(int idPort) {
		this.idPort = idPort;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setServices(ServiceDTO[] services) {
		this.services = services;
	}

}
