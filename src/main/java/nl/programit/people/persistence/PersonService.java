package nl.programit.people.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.people.domain.Person;

@Service
@Transactional
public class PersonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	private PersonRepository personRepository;
	
	public void save(Person person) {
		
		LOGGER.error("it rocks");
		
		this.personRepository.save(person);		

	}
	
	public Iterable<Person> findAll() {
		Iterable<Person> result = this.personRepository.findAll();
		
		return result;
	}

}
