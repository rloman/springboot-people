package nl.programit.people.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.people.domain.Person;

@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public void save(Person person) {
		this.personRepository.save(person);
	}	
	
	public Iterable<Person> findAll() {
		Iterable<Person> result = this.personRepository.findAll();
		return result;
	}
}
