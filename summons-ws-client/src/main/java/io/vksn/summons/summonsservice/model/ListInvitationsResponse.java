
package io.vksn.summons.summonsservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import io.vksn.summons.entity.Invitation;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invitations" type="{http://vksn.io/summons/entity/}Invitation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "invitations"
})
@XmlRootElement(name = "listInvitationsResponse")
public class ListInvitationsResponse {

    protected List<Invitation> invitations;

    /**
     * Gets the value of the invitations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the invitations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInvitations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Invitation }
     * 
     * 
     */
    public List<Invitation> getInvitations() {
        if (invitations == null) {
            invitations = new ArrayList<Invitation>();
        }
        return this.invitations;
    }

}
