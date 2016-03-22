package io.vksn.summons.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
@XmlType(name="table", propOrder={
		"id",
		"position",
		"size",
		"angle",
		"chairs"
})
@XmlAccessorType(XmlAccessType.FIELD)
@SequenceGenerator(name="TABLE_SEQ", sequenceName="table_seq", initialValue=100)
public class Table {
	@Id
	@GeneratedValue(generator="TABLE_SEQ", strategy=GenerationType.SEQUENCE)
	@XmlElement
	private Long id;
	
	@Embedded
	@XmlElement
	private Position position;
	
	@Embedded
	@XmlElement
	private Size size;
	
	@Column
	@XmlElement
	private double angle;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@XmlElement
	private List<Chair> chairs;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	public List<Chair> getChairs() {
		return chairs;
	}
	public void setChairs(List<Chair> chairs) {
		this.chairs = chairs;
	}
}
