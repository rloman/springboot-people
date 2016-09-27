package nl.programit.people.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 5801378338363587926L;

	// technical key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;	
	
	private String firstName;
	private String lastName;

	@OneToOne
	private Address address;	
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Phone> phones = new ArrayList<>();

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Hobby> hobbies = new ArrayList<>();

	public List<Phone> getPhones() {
		return phones;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}	
	
	public List<Hobby> getHobbies() {
		return hobbies;
	}
	
	public void addHobby(Hobby hobby) {
		this.hobbies.add(hobby);
	}

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

}
