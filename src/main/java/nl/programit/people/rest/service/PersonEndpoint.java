package nl.programit.people.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.programit.people.domain.Person;
import nl.programit.people.domain.Phone;
import nl.programit.people.persistence.PersonService;

@Path("/people")
@Component
public class PersonEndpoint {

	@Autowired
	private PersonService personService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		Iterable<Person> result = this.personService.findAll();
		return Response.ok(result).build();
	}


}