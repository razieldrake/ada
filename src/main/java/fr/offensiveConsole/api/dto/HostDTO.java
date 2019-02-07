package fr.offensiveConsole.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.offensiveConsole.api.domain.Port;

@JsonInclude(value=Include.NON_EMPTY)
public class HostDTO {
	
	private long idHost;
	
	private String nameHost;
	
	private String ip;
	
	private String os;
	
	private boolean isNew;
	
	private PortDTO[] ports;

	public long getId() {
		return idHost;
	}

	public String getName() {
		return nameHost;
	}

	public String getIp() {
		return ip;
	}

	public String getOs() {
		return os;
	}

	public boolean isNew() {
		return isNew;
	}

	public PortDTO[] getPorts() {
		return ports;
	}

	public void setId(long idHost) {
		this.idHost = idHost;
	}

	public void setName(String nameHost) {
		this.nameHost = nameHost;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void setPorts(PortDTO[] ports) {
		this.ports = ports;
	}

}
