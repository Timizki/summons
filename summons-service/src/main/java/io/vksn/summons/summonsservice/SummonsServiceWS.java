
package io.vksn.summons.summonsservice;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import io.vksn.summons.entity.Event;
import io.vksn.summons.summonsservice.model.CreateEvent;
import io.vksn.summons.summonsservice.model.CreateEventResponse;
import io.vksn.summons.summonsservice.model.GetSessionStartTime;
import io.vksn.summons.summonsservice.model.ListEvents;
import io.vksn.summons.summonsservice.model.ListEventsResponse;
import io.vksn.summons.summonsservice.model.ListInvitationsResponse;
import io.vksn.summons.summonsservice.model.Login;
import io.vksn.summons.summonsservice.model.LoginResponse;
import io.vksn.summons.summonsservice.model.Participate;
import io.vksn.summons.summonsservice.model.ParticipateResponse;
import org.w3._2001.xmlschema.Adapter1;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6b21 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SummonsServiceWS", targetNamespace = "http://vksn.io/summons/summonsService/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    io.vksn.summons.entity.ObjectFactory.class,
    io.vksn.summons.summonsservice.model.ObjectFactory.class
})
public interface SummonsServiceWS {


    /**
     * 
     * @param listInvitations
     * @return
     *     returns io.vksn.summons.summonsservice.model.ListInvitationsResponse
     */
    @WebMethod
    @WebResult(name = "listInvitationsResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "listInvitationsResponse")
    public ListInvitationsResponse listInvitations(
        @WebParam(name = "listInvitations", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "listInvitations")
        long listInvitations);

    /**
     * 
     * @param createEvent
     * @return
     *     returns io.vksn.summons.summonsservice.model.CreateEventResponse
     */
    @WebMethod
    @WebResult(name = "createEventResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "createEventResponse")
    public CreateEventResponse createEvent(
        @WebParam(name = "createEvent", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "createEvent")
        CreateEvent createEvent);

    /**
     * 
     * @param fetchEvent
     * @return
     *     returns io.vksn.summons.entity.Event
     */
    @WebMethod
    @WebResult(name = "fetchEventResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "fetchEventResponse")
    public Event fetchEvent(
        @WebParam(name = "fetchEvent", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "fetchEvent")
        long fetchEvent);

    /**
     * 
     * @param listEvents
     * @return
     *     returns io.vksn.summons.summonsservice.model.ListEventsResponse
     */
    @WebMethod
    @WebResult(name = "listEventsResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "listEventsResponse")
    public ListEventsResponse listEvents(
        @WebParam(name = "listEvents", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "listEvents")
        ListEvents listEvents);

    /**
     * 
     * @param getSessionStartTime
     * @return
     *     returns java.util.Date
     */
    @XmlJavaTypeAdapter(Adapter1 .class)
    @WebMethod
    @WebResult(name = "getSessionStartTimeResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "getSessionStartTimeResponse")
    public Date getSessionStartTime(
        @WebParam(name = "getSessionStartTime", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "getSessionStartTime")
        GetSessionStartTime getSessionStartTime);

    /**
     * 
     * @param login
     * @return
     *     returns io.vksn.summons.summonsservice.model.LoginResponse
     */
    @WebMethod
    @WebResult(name = "loginResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "loginResponse")
    public LoginResponse login(
        @WebParam(name = "login", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "login")
        Login login);

    /**
     * 
     * @param participate
     * @return
     *     returns io.vksn.summons.summonsservice.model.ParticipateResponse
     */
    @WebMethod
    @WebResult(name = "participateResponse", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "participateResponse")
    public ParticipateResponse participate(
        @WebParam(name = "participate", targetNamespace = "http://vksn.io/summons/summonsService/model/", partName = "participate")
        Participate participate);

}
