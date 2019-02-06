package fr.offensiveConsole.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import fr.offensiveConsole.api.domain.CVE;

@JsonInclude(value=Include.NON_EMPTY)
public class ServiceDTO {
	
	private long idService;
	
	private String nameService;
	
	private String versionService;
	
	private CVE[] cves;

	public long getIdService() {
		return idService;
	}

	public String getNameService() {
		return nameService;
	}

	public String getVersionService() {
		return versionService;
	}

	public CVE[] getCves() {
		return cves;
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

	public void setCves(CVE[] cves) {
		this.cves = cves;
	}

}
