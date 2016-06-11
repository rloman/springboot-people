package nl.programit.people.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.programit.people.domain.Category;
import nl.programit.people.persistence.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/Cinsert") // please listen :-) to the list - request
	public String list(Model model) { // please inject a Model since that is the
										// M in MVC which Spring Boot likes to
										// see (what else can he see!!!!!!!)

		Iterable<Category> category = this.categoryService.findAll();
		model.addAttribute("categories", category);

		return "Clist"; // render something like list.html

	}

	@RequestMapping(value = "/Cinsert", method = RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "Clist";
	}

	@RequestMapping(value = "/Cinsert", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("name") String name,
			@RequestParam(required = false, value = "renderPresentationNotes") boolean renderPresentationNotes,
			@RequestParam("chapter") String chapter, HttpServletResponse response) {

		Category category = new Category();
		category.setChapter(chapter);
		category.setName(name);


		this.categoryService.save(category);
		return "/Clist";

	}
}
