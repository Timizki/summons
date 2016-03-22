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
@SequenceGenerator(name="coverletter_seq", sequenceName="coverletter_seq")
@XmlType(name="CoverLetter", propOrder = {
		"id",
		"content"
})
public class CoverLetter {

	@Id
	@XmlElement
	@GeneratedValue(generator="coverletter_seq", strategy=GenerationType.SEQUENCE)
	protected long id;
	@Column
	@XmlElement(required=true)
	protected String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
