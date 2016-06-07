package nl.programit.people.persistence;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import nl.programit.people.domain.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

	private static final String JANSSEN = "Janssen";
	private static final String HANS = "Hans";

	@InjectMocks
	private PersonService personService;

	@Mock
	private PersonRepository personRepository;

	@Test
	public void testSave() {
		// mocking part
		Person personMock = new Person();
		personMock.setId(1);
		personMock.setFirstName(HANS);
		personMock.setLastName(JANSSEN);

		Person personToBeSaved = new Person();
		personToBeSaved.setFirstName(HANS);
		personToBeSaved.setLastName(JANSSEN);

		// contract voor de aanroep naar de personRepository
		Mockito.when(personRepository.save(personToBeSaved)).thenReturn(personMock);

		// testing part
		Person personSaved = this.personService.save(personToBeSaved);

		Assert.assertEquals(1, personSaved.getId());
		Assert.assertEquals(JANSSEN, personSaved.getLastName());
		Assert.assertEquals(HANS, personSaved.getFirstName());
	}

	@Test
	public void testFindAll() {

	}
}
