package nl.programit.people.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import nl.programit.people.domain.Fiets;

@Component
public interface FietsRepository extends CrudRepository<Fiets, Long> { 
	
	Fiets findByMerk(String merk);
}

