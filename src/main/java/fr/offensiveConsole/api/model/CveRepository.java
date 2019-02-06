package fr.offensiveConsole.api.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.offensiveConsole.api.domain.CVE;

@Repository
public interface CveRepository extends CrudRepository<CVE,String> {

}
