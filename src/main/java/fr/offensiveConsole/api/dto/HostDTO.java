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
	
	private Port[] ports;

	public long getIdHost() {
		return idHost;
	}

	public String getNameHost() {
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

	public Port[] getPorts() {
		return ports;
	}

	public void setIdHost(long idHost) {
		this.idHost = idHost;
	}

	public void setNameHost(String nameHost) {
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

	public void setPorts(Port[] ports) {
		this.ports = ports;
	}

}
