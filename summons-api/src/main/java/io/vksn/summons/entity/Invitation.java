package io.vksn.summons.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Invitation", propOrder = { "id", "token", "coverLetter", "persons" })
@SequenceGenerator(name="invitation_seq", sequenceName="invitation_seq")
public class Invitation {
	@Id
	@XmlElement
	@GeneratedValue(generator="invitation_seq", strategy=GenerationType.SEQUENCE)
	private long id;

	@Column(unique = true, nullable = false)
	@XmlElement(required = true)
	@Size(min = 8)
	private String token;
	
	@ManyToOne
	@JoinColumn(nullable=true)
	@XmlElement
	protected CoverLetter coverLetter;

	@OneToMany(cascade = CascadeType.ALL)
	@XmlElement(required = true)
	protected List<Person> persons;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public CoverLetter getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(CoverLetter coverLetter) {
		this.coverLetter = coverLetter;
	}

	public List<Person> getPersons() {
		if(this.persons == null ){
			this.persons = new ArrayList<>();
		}
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
