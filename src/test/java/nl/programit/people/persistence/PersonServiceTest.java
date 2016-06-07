package nl.programit.people.persistence;

import org.junit.Assert;
import org.junit.Test;

import nl.programit.people.domain.Person;

public class PersonServiceTest {
	
	private PersonService personService  = new PersonService();
	
	@Test
	public void testSave() {
		
		Person personToBeSaved = new Person();
		personToBeSaved.setId(33);
		Person personSaved = this.personService.save(personToBeSaved);
		
		Assert.assertEquals(33, personSaved.getId());
	}
}
