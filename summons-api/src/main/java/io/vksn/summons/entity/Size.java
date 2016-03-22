package io.vksn.summons.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Embeddable
@XmlType(name="size",propOrder={
		"height",
		"width"
})
@XmlAccessorType(XmlAccessType.FIELD)
public class Size {
	
	@Column
	@XmlElement
	private double height;
	@Column
	@XmlElement
	private double width;

	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
}
