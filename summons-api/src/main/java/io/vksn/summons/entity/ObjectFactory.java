
package io.vksn.summons.entity;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.vksn.summons.entity package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Invitation_QNAME = new QName("http://vksn.io/summons/entity/", "invitation");
    private final static QName _Person_QNAME = new QName("http://vksn.io/summons/entity/", "Person");
    private final static QName _Event_QNAME = new QName("http://vksn.io/summons/entity/", "Event");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.vksn.summons.entity
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Invitation }
     * 
     */
    public Invitation createInvitation() {
        return new Invitation();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link CoverLetter }
     * 
     */
    public CoverLetter createCoverLetter() {
        return new CoverLetter();
    }

    /**
     * Create an instance of {@link ContactInformation }
     * 
     */
    public ContactInformation createContactInformation() {
        return new ContactInformation();
    }

    /**
     * Create an instance of {@link Place }
     * 
     */
    public Place createPlace() {
        return new Place();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invitation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/entity/", name = "invitation")
    public JAXBElement<Invitation> createInvitation(Invitation value) {
        return new JAXBElement<Invitation>(_Invitation_QNAME, Invitation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/entity/", name = "Person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Event }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/entity/", name = "Event")
    public JAXBElement<Event> createEvent(Event value) {
        return new JAXBElement<Event>(_Event_QNAME, Event.class, null, value);
    }

}
