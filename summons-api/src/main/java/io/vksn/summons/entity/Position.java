package io.vksn.summons.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Embeddable
@XmlType(name = "position", propOrder = { "top", "left" , "relativeLeft", "relativeTop"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Position {

	@Column
	@XmlElement
	private double top;
	@Column
	@XmlElement
	private double left;


	@Column
	@XmlElement
	private double relativeTop;
	@Column
	@XmlElement
	private double relativeLeft;
	
	public double getTop() {
		return top;
	}

	public void setTop(double top) {
		this.top = top;
	}

	public double getLeft() {
		return left;
	}

	public void setLeft(double left) {
		this.left = left;
	}
	
	public double getRelativeLeft() {
		return relativeLeft;
	}
	public void setRelativeLeft(double relativeLeft) {
		this.relativeLeft = relativeLeft;
	}
}
