package fr.offensiveConsole.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_EMPTY)
public class CVEDTO {
	
	private String idCVE;
	
	private float baseScore;
	
	
	private float impactScore;
	
	
	private String vector;
	
	
	private String attackVector;
	
	
	private String descriptionCVE;


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

}
