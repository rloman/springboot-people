package nl.programit.people.persistence;

import org.springframework.data.repository.CrudRepository;

import nl.programit.people.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findByChapter(String chapter);
}
