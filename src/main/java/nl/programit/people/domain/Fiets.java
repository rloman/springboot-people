package nl.programit.people.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Fiets {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Person> eigenaren = new ArrayList<>();
	
	private String merk;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public List<Person> getEigenaren() {
		return eigenaren;
	}

	public void setEigenaren(List<Person> eigenaren) {
		this.eigenaren = eigenaren;
	}

}
