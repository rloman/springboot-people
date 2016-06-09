package nl.programit.people.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import com.udr.models.User;
@Entity
public class Category  {
	@ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Person person;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long catId;
	private String name;
	private String chapter;
//	private Question questions;
	
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
//	public Question getQuestions() {
//		return questions;
//	}
//	public void setQuestions(Question questions) {
//		this.questions = questions;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
