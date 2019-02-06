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

import fr.offensiveConsole.api.domain.Port;

@Entity
@Table(name="Service")
@JsonInclude(value = Include.NON_DEFAULT)
public class Service {
	
	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idService;
	
	@JsonProperty
	private String nameService;
	
	@JsonProperty
	private String versionService;
	
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
 	private Collection<CVE> cves = new ArrayList<CVE>();
	
	private Port port;
	
	protected Service() {
		
	}
	
	@JsonCreator
	public Service(@JsonProperty("id_service")long idserv,
				   @JsonProperty("name_service") String name,
				   @JsonProperty("version_service") String version) {
		
		this.idService = idserv;
		this.nameService = name;
		
	}

	public long getIdService() {
		return idService;
	}

	public String getNameService() {
		return nameService;
	}

	public String getVersionService() {
		return versionService;
	}
	
	public Port getPort() {
		return this.port;
	}

	public Collection<CVE> getCve() {
		return this.cves;
	}

	public void setIdService(long idService) {
		this.idService = idService;
	}

	public void setNameService(String nameService) {
		this.nameService = nameService;
	}

	public void setVersionService(String versionService) {
		this.versionService = versionService;
	}

	public void setCve(Collection<CVE> cves) {
		this.cves = cves;
	}
	
	public void setort(Port port) {
		this.port=  port;
	}
	

}
