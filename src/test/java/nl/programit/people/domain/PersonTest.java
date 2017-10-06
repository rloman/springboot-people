package nl.programit.people.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {

    private Person person;


    @Before
    public void setUp() {

            this.person = new Person();

    }
    @Test
    public void testSetGetFirstname() {


            this.person.setFirstName("Raymie");

            Assert.assertEquals("Raymie", this.person.getFirstName());
    }
}
