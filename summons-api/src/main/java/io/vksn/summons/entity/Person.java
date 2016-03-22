package io.vksn.summons.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@SequenceGenerator(name="person_seq", sequenceName="person_seq")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Person", propOrder={
		"id",
		"participate",
		"contactInfo",
		"firstName",
		"lastName"
})
public class Person {

	@Id
	@GeneratedValue(generator="person_seq", strategy=GenerationType.SEQUENCE)
	@XmlElement
	protected long id;
	@Column
	@XmlElement(defaultValue="NOT_RESPONSED")
	protected Participate participate;
	@OneToMany
	@XmlElement
	protected List<ContactInformation> contactInfo;
	@Column
	@XmlElement(required=true)
	protected String firstName;
	@Column
	@XmlElement(required=true)
	protected String lastName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Participate getParticipate() {
		return participate;
	}

	public void setParticipate(Participate participate) {
		this.participate = participate;
	}

	public List<ContactInformation> getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(List<ContactInformation> contactInfo) {
		this.contactInfo = contactInfo;
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

}
