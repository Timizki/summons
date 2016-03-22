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
@SequenceGenerator(name="contactinfo_seq", sequenceName="contactinfo_seq")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ContactInformation", propOrder= {
		"id",
		"type",
		"contactInfo"
})
public class ContactInformation {

	@Id
	@XmlElement
	@GeneratedValue(generator="contactinfo_seq", strategy=GenerationType.SEQUENCE)
	protected long id;
	@Column
	@XmlElement
	protected String type;
	@Column
	@XmlElement(required=true)
	protected String contactInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
}
