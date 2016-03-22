
package io.vksn.summons.summonsservice.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="invitation" type="{http://vksn.io/summons/entity/}Invitation"/>
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
    "invitation"
})
@XmlRootElement(name = "addInvitation")
public class AddInvitation {

    @XmlElement(required = true)
    protected Invitation invitation;

    /**
     * Gets the value of the invitation property.
     * 
     * @return
     *     possible object is
     *     {@link Invitation }
     *     
     */
    public Invitation getInvitation() {
        return invitation;
    }

    /**
     * Sets the value of the invitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Invitation }
     *     
     */
    public void setInvitation(Invitation value) {
        this.invitation = value;
    }

}
