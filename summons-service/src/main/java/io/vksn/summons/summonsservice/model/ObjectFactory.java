
package io.vksn.summons.summonsservice.model;

import java.util.Date;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import io.vksn.summons.entity.Event;
import org.w3._2001.xmlschema.Adapter1;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the io.vksn.summons.summonsservice.model package. 
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

    private final static QName _GetSessionStartTimeResponse_QNAME = new QName("http://vksn.io/summons/summonsService/model/", "getSessionStartTimeResponse");
    private final static QName _AddInvitationResponse_QNAME = new QName("http://vksn.io/summons/summonsService/model/", "addInvitationResponse");
    private final static QName _FetchEvent_QNAME = new QName("http://vksn.io/summons/summonsService/model/", "fetchEvent");
    private final static QName _ListInvitations_QNAME = new QName("http://vksn.io/summons/summonsService/model/", "listInvitations");
    private final static QName _FetchEventResponse_QNAME = new QName("http://vksn.io/summons/summonsService/model/", "fetchEventResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.vksn.summons.summonsservice.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListEventsResponse }
     * 
     */
    public ListEventsResponse createListEventsResponse() {
        return new ListEventsResponse();
    }

    /**
     * Create an instance of {@link ListInvitationsResponse }
     * 
     */
    public ListInvitationsResponse createListInvitationsResponse() {
        return new ListInvitationsResponse();
    }

    /**
     * Create an instance of {@link ListEvents }
     * 
     */
    public ListEvents createListEvents() {
        return new ListEvents();
    }

    /**
     * Create an instance of {@link GetSessionStartTime }
     * 
     */
    public GetSessionStartTime createGetSessionStartTime() {
        return new GetSessionStartTime();
    }

    /**
     * Create an instance of {@link CreateEvent }
     * 
     */
    public CreateEvent createCreateEvent() {
        return new CreateEvent();
    }

    /**
     * Create an instance of {@link AddInvitation }
     * 
     */
    public AddInvitation createAddInvitation() {
        return new AddInvitation();
    }

    /**
     * Create an instance of {@link CreateEventResponse }
     * 
     */
    public CreateEventResponse createCreateEventResponse() {
        return new CreateEventResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/summonsService/model/", name = "getSessionStartTimeResponse")
    @XmlJavaTypeAdapter(Adapter1 .class)
    public JAXBElement<Date> createGetSessionStartTimeResponse(Date value) {
        return new JAXBElement<Date>(_GetSessionStartTimeResponse_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/summonsService/model/", name = "addInvitationResponse")
    public JAXBElement<Object> createAddInvitationResponse(Object value) {
        return new JAXBElement<Object>(_AddInvitationResponse_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/summonsService/model/", name = "fetchEvent")
    public JAXBElement<Long> createFetchEvent(Long value) {
        return new JAXBElement<Long>(_FetchEvent_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/summonsService/model/", name = "listInvitations")
    public JAXBElement<Long> createListInvitations(Long value) {
        return new JAXBElement<Long>(_ListInvitations_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Event }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://vksn.io/summons/summonsService/model/", name = "fetchEventResponse")
    public JAXBElement<Event> createFetchEventResponse(Event value) {
        return new JAXBElement<Event>(_FetchEventResponse_QNAME, Event.class, null, value);
    }

}
