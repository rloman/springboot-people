package nl.programit.people.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nl.programit.people.domain.Category;

@Service
@Transactional
public class CategoryService {
private static final Logger LOGGER = LoggerFactory.getLogger(CategoryService.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category save(Category category) {
		
		LOGGER.debug("it rocks");
		
		// aanroep van het door Mockito gemaakte contract (normaliter zet je dat natuurlijk hier
//		niet in de code 
		Category result = this.categoryRepository.save(category);	
		
		return result;

	}
	
	public Iterable<Category> findAll() {
		Iterable<Category> result = this.categoryRepository.findAll();
		
		return result;
	}

}
