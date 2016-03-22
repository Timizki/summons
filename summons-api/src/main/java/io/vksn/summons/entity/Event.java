package io.vksn.summons.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@SequenceGenerator(name="eventSEQ", sequenceName="event_seq")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Event", propOrder = {
    "id",
	"sign",
    "name",
    "date",
    "choosedPlace",
    "suggestedPlaces",
    "invitations",
    "seatingPlan"
    
})
@NamedQueries({
	@NamedQuery(name=Event.FIND_BY_ID, query="SELECT e FROM Event e WHERE e.id=:id"),
	@NamedQuery(name=Event.FIND_BY_SIGN, query="SELECT e FROM Event e WHERE e.sign=:sign"),
	@NamedQuery(name=Event.FIND_ALL, query="SELECT e FROM Event e")
})
public class Event {
	public static final String FIND_ALL = "event.find_all";
	public static final String FIND_BY_ID = "event.find_by_id";
	public static final String FIND_BY_SIGN = "event.find_by_sign";
	

	@Id
	@GeneratedValue(generator="eventSEQ", strategy=GenerationType.SEQUENCE)
	@XmlElement
	protected long id;
	
	@Column(unique=true)
	@XmlElement
	protected String sign;

	@Column
	@Temporal(TemporalType.DATE)
	@XmlElement
	protected Date date;

	@Column
	@XmlElement
	protected String name;
	
	@OneToOne(cascade={CascadeType.ALL})
	@XmlElement
	protected Place choosedPlace;

	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@XmlElement
	protected List<Place> suggestedPlaces;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@XmlElement
	protected List<Invitation> invitations;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@XmlElement
	protected List<Table> seatingPlan;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSign() {
		return sign;
	}
	
	public void setSign(String sing) {
		this.sign = sing;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Place getChoosedPlace() {
		return choosedPlace;
	}

	public void setChoosedPlace(Place choosedPlace) {
		this.choosedPlace = choosedPlace;
	}

	public List<Place> getSuggestedPlaces() {
		return suggestedPlaces;
	}

	public void setSuggestedPlaces(List<Place> suggestedPlaces) {
		this.suggestedPlaces = suggestedPlaces;
	}

	public List<Invitation> getInvitations() {
		if(this.invitations == null) {
			this.invitations = new ArrayList<>();
		}
		return invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}
	
	public List<Table> getSeatingPlan() {
		return seatingPlan;
	}
	
	public void setSeatingPlan(List<Table> seatingPlan) {
		this.seatingPlan = seatingPlan;
	}
}
