package fr.offensiveConsole.api.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="CVE")
@JsonInclude(value = Include.NON_DEFAULT)
public class CVE {
	
	@JsonProperty
	@Id
	private String idCVE;
	
	
	@JsonProperty
	private float baseScore;
	
	@JsonProperty
	private float impactScore;
	
	@JsonProperty
	private String vector;
	
	@JsonProperty
	private String attackVector;
	
	@JsonProperty
	private String descriptionCVE;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Service service;
	
	protected CVE() {
		
	}
	
	public CVE(@JsonProperty("id_cve")String idcve,
			   @JsonProperty("base_score")float bscore,
			   @JsonProperty("impact_score")float iscore,
			   @JsonProperty("vector")String vector,
			   @JsonProperty("attack_vector")String attackVector,
			   @JsonProperty("description_cve")String desc) {
		
		this.idCVE = idcve;
		this.baseScore = bscore;
		this.impactScore = iscore;
		this.vector = vector;
		this.attackVector = attackVector;
		this.descriptionCVE = desc;
	}

	public String getIdCVE() {
		return idCVE;
	}

	public float getBaseScore() {
		return baseScore;
	}

	public float getImpactScore() {
		return impactScore;
	}

	public String getVector() {
		return vector;
	}

	public String getAttackVector() {
		return attackVector;
	}

	public String getDescriptionCVE() {
		return descriptionCVE;
	}
	public Service getService() {
		return this.service;
	}

	public void setIdCVE(String idCVE) {
		this.idCVE = idCVE;
	}

	public void setBaseScore(float baseScore) {
		this.baseScore = baseScore;
	}

	public void setImpactScore(float impactScore) {
		this.impactScore = impactScore;
	}

	public void setVector(String vector) {
		this.vector = vector;
	}

	public void setAttackVector(String attackVector) {
		this.attackVector = attackVector;
	}

	public void setDescriptionCVE(String descriptionCVE) {
		this.descriptionCVE = descriptionCVE;
	}
	
	public void setService(Service service) {
		this.service = service;
	}
	

}
