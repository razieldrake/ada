package fr.offensiveConsole.api.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.offensiveConsole.api.domain.Host;

@Entity
@Table(name="Job")
@JsonInclude(value = Include.NON_DEFAULT)
public class Job {
	
/*	@JsonProperty
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idJob;
	
	@JsonProperty
	private String nameJob;
	
	@JsonProperty
	private String descriptionJob;
	
	@JsonProperty
	private String statusJob;
	

	@JsonProperty
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
	private LocalDate startedAt;
	
	@JsonProperty
	@JsonFormat(pattern = "yyyy-MM-dd@HH:mm")
	private LocalDate endAt;
	
	@JsonIgnore
	@OneToMany(mappedBy= "job", cascade=CascadeType.ALL)
	private Collection<Host> hostList = new ArrayList<Host>();
	
	protected Job() {
		
	}
	
	
*/
}
