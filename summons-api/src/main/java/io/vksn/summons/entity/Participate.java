package io.vksn.summons.entity;

import javax.xml.bind.annotation.XmlType;

@XmlType(name="Participate")
public enum Participate {

	PARTICIPATES, WONT_PARTICIPATE, NOT_RESPONSED;

	public String value() {
		return name();
	}

	public static Participate fromValue(String v) {
		return valueOf(v);
	}

}