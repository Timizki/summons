package io.vksn.summons.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
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
@XmlType(name="chair",propOrder= {
		"id",
		"personId",
		"position"
})
@XmlAccessorType(XmlAccessType.FIELD)
@SequenceGenerator(name="CHAIR_SEQ", sequenceName="chair_seq")
public class Chair {
	
	@Id
	@GeneratedValue(generator="CHAIR_SEQ", strategy=GenerationType.SEQUENCE)
	@XmlElement
	private long id;
	@Column
	@XmlElement
	private long personId;
	
	@Embedded
	@XmlElement
	private Position position;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getPersonId() {
		return personId;
	}
	
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
}
