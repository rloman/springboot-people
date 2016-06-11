package nl.programit.people.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.people.domain.Category;
import nl.programit.people.domain.Person;

@Service
@Transactional
public class PersonService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Person save(Person person) {
		
		LOGGER.debug("it rocks");
		
		// aanroep van het door Mockito gemaakte contract (normaliter zet je dat natuurlijk hier
//		niet in de code 
		Person result = this.personRepository.save(person);	
		
		return result;

	}
	
	public Iterable<Person> findAll() {
		Iterable<Person> result = this.personRepository.findAll();
		
		return result;
	}
public Category save2(Category category) {
		
		LOGGER.debug("it rocks");
		
		// aanroep van het door Mockito gemaakte contract (normaliter zet je dat natuurlijk hier
//		niet in de code 
		Category result = this.categoryRepository.save(category);	
		
		return result;

	}
	


}
