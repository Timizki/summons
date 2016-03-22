package io.vksn.summons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@SequenceGenerator(name="address_seq", sequenceName="address_seq")
@XmlType(name="Address", propOrder= {
		"id",
		"street",
		"city",
		"altitude",
		"longitude"
})
public class Address {

	@Id
	@GeneratedValue(generator="address_seq", strategy=GenerationType.SEQUENCE)
	private long id;

	@Column
	@XmlElement(required=true)
	protected String street;
	@Column
	@XmlElement(required=true)
	protected String city;
	@Column
	@XmlElement
	protected String altitude;
	@Column
	@XmlElement
	protected String longitude;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
