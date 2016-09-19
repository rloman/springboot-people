package nl.programit.people.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.programit.people.domain.Person;
import nl.programit.people.persistence.PersonService;

@Controller
public class PersonController {

   @Autowired
   private PersonService personService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody String list() {
       return this.personService.findAll().toString();
    }

   @RequestMapping(value = "/insert", method = RequestMethod.POST)
   public void handleFileUpload(@RequestParam("name") String name,
       @RequestParam(required = false, value = "renderPresentationNotes") boolean renderPresentationNotes,
       @RequestParam("lastName") String lastName, HttpServletResponse response) {
	       Person person = new Person();
	       person.setFirstName(name);
	       person.setLastName(lastName);
	
	       this.personService.save(person);
       }
}
