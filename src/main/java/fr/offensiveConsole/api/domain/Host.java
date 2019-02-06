package fr.offensiveConsole.api.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="Host")
@JsonInclude(value = Include.NON_DEFAULT)
public class Host {
	
	@Id
	@JsonProperty
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonProperty
	private String ip;
	
	@JsonProperty
	private String nameHost;
	
	@JsonProperty
	private String os;
	
	@JsonProperty
	private boolean isNew;
	
	@OneToMany(mappedBy= "host", cascade=CascadeType.ALL)
	private Collection<Port> ports = new ArrayList<Port>();
	
	//	@JsonIgnore
	//	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	//	private Job job;
	
	protected Host() {
		
	}
	
	@JsonCreator
	public Host(@JsonProperty("id_host") Long id,
				@JsonProperty("ip") String ip,
				@JsonProperty("os") String os,
				@JsonProperty("is_new") boolean isNew,
				@JsonProperty("name_host")String name){
		
		this.id = id;	 
		this.ip = ip; 		
		this.os = os;		 
		this.isNew = isNew;
		this.nameHost = name;
		
	}

	public Long getId() {
		return id;
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

	public Collection<Port> getPorts() {
		return ports;
	}
	
	public String getnameHost() {
		return this.nameHost;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setPorts(Collection<Port> ports) {
		this.ports = ports;
	}
	
	public void setName(String name) {
		this.nameHost = name;
	}
	
	

	

}
