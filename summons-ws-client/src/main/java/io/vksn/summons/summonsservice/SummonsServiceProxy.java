package io.vksn.summons.summonsservice;

import java.net.URL;
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import io.vksn.summons.entity.Event;
import io.vksn.summons.summonsservice.model.CreateEvent;
import io.vksn.summons.summonsservice.model.CreateEventResponse;
import io.vksn.summons.summonsservice.model.GetSessionStartTime;
import io.vksn.summons.summonsservice.model.ListEvents;
import io.vksn.summons.summonsservice.model.ListEventsResponse;
import io.vksn.summons.summonsservice.model.ListInvitationsResponse;

public class SummonsServiceProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private io.vksn.summons.summonsservice.SummonsService _service = null;
        private io.vksn.summons.summonsservice.SummonsServiceWS _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new io.vksn.summons.summonsservice.SummonsService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            _service = new io.vksn.summons.summonsservice.SummonsService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getSummonsService();
        }

        public io.vksn.summons.summonsservice.SummonsServiceWS getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "SummonsService");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if (_dispatch != null ) {
                bp = (BindingProvider) _dispatch;
                bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public SummonsServiceProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public SummonsServiceProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public ListInvitationsResponse listInvitations(long listInvitations) {
        return _getDescriptor().getProxy().listInvitations(listInvitations);
    }

    public CreateEventResponse createEvent(CreateEvent createEvent) {
        return _getDescriptor().getProxy().createEvent(createEvent);
    }

    public Event fetchEvent(long fetchEvent) {
        return _getDescriptor().getProxy().fetchEvent(fetchEvent);
    }

    public ListEventsResponse listEvents(ListEvents listEvents) {
        return _getDescriptor().getProxy().listEvents(listEvents);
    }

    public Date getSessionStartTime(GetSessionStartTime getSessionStartTime) {
        return _getDescriptor().getProxy().getSessionStartTime(getSessionStartTime);
    }

}