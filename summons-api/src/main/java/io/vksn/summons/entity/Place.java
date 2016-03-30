package io.vksn.summons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@SequenceGenerator(name = "place_seq", sequenceName = "place_seq")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Place", propOrder = { "id", "name", "address", "drivingInstructions", "website" })
public class Place {
	@Id
	@XmlElement
	@GeneratedValue(generator = "place_seq", strategy = GenerationType.SEQUENCE)
	private long id;

	@Column
	@XmlElement(required = true)
	protected String name;

	@OneToOne
	@XmlElement(required = true)
	protected Address address;
	@Column
	@XmlElement
	protected String drivingInstructions;

	@Column
	@XmlElement
	protected String website;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDrivingInstructions() {
		return drivingInstructions;
	}

	public void setDrivingInstructions(String drivingInstructions) {
		this.drivingInstructions = drivingInstructions;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
}
