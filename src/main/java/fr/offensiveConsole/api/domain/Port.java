package fr.offensiveConsole.api.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="Port")
@JsonInclude(value = Include.NON_DEFAULT)
public class Port {
	
	
	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPort;
	
	@JsonProperty
	private String protocolPort;
	@JsonProperty
	private String statusPort;
	
	@OneToMany(mappedBy= "port", cascade=CascadeType.ALL)
	private Collection<Service> services = new ArrayList<Service>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id", nullable = false)
	private Host host;
	
	protected Port() {
		
	}
	
	@JsonCreator
	public Port (@JsonProperty("id_port") int idp,
				 @JsonProperty("status_port") String status,
				 @JsonProperty("protocol_port") String protocol) {
		
		this.idPort = idp;
		this.statusPort = status;
		this.protocolPort = protocol;
	}

	public int getIdPort() {
		return idPort;
	}

	public String getProtocolPort() {
		return protocolPort;
	}

	public String getStatusPort() {
		return statusPort;
	}
	
	public Host getHost() {
		return this.host;
	}
	
	public Collection<Service> getService(){
		return this.services;
	}

	public void setIdPort(int idPort) {
		this.idPort = idPort;
	}

	public void setProtocolPort(String protocolPort) {
		this.protocolPort = protocolPort;
	}

	public void setStatusPort(String statusPort) {
		this.statusPort = statusPort;
	}
	
	public void setHost(Host host) {
		this.host = host;
	}
	
	public void setService(Collection<Service> service) {
		
		this.services = service;
	}
	
	

}
