package nl.programit.people.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import nl.programit.people.domain.Person;

@Path("/people")
@Component
public class PersonService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {

		Person p = new Person();
		p.setFirstName("Piet");
		p.setLastName("Jansen");

		return Response.accepted(p).build();

	}

}
