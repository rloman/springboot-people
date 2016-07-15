package nl.programit.people.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.programit.people.domain.Fiets;
import nl.programit.people.domain.Person;
import nl.programit.people.persistence.FietsService;
import nl.programit.people.persistence.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private FietsService fietsService;

	@RequestMapping("/list") // please listen :-) to the list - request
	public String list(Model model) { // please inject a Model since that is the
										// M in MVC which Spring Boot likes to
										// see (what else can he see!!!!!!!)

		Iterable<Person> people = this.personService.findAll();
		model.addAttribute("people", people);

		return "list"; // render something like list.html

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "You can upload some by posting to this url.";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void handleFileUpload(@RequestParam("name") String name,
			@RequestParam(required = false, value = "renderPresentationNotes") boolean renderPresentationNotes,
			@RequestParam("lastName") String lastName, HttpServletResponse response) {

		Person person = new Person();
		person.setFirstName(name);
		person.setLastName(lastName);

		this.personService.save(person);

		Fiets fiets = new Fiets();
		fiets.setMerk("Batavus");
		this.fietsService.save(fiets);

		person.getFietsen().add(fiets);
		fiets.getEigenaren().add(person);

		this.personService.save(person);
		this.fietsService.save(fiets);

	}
}
