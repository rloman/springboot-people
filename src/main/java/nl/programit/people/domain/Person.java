package nl.programit.people.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 5801378338363587926L;

	// technical key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy="eigenaren", cascade=CascadeType.ALL)
	private List<Fiets> fietsen = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public List<Fiets> getFietsen() {
		return fietsen;
	}

	public void setFietsen(List<Fiets> fietsen) {
		this.fietsen = fietsen;
	}
	

	// feature
	// Person should print nicer

}
