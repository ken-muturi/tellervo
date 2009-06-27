//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.26 at 05:22:23 PM PDT 
//


package org.tridas.schema;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


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
 *         &lt;element ref="{http://www.tridas.org/1.2}nrOfSapwoodRings" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}lastRingUnderBark" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}missingSapwoodRingsToBark" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}missingSapwoodRingsToBarkFoundation" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="presence" use="required" type="{http://www.tridas.org/1.2}complexPresenceAbsence" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nrOfSapwoodRings",
    "lastRingUnderBark",
    "missingSapwoodRingsToBark",
    "missingSapwoodRingsToBarkFoundation"
})
@XmlRootElement(name = "sapwood")
public class TridasSapwood
    implements Serializable
{

    private final static long serialVersionUID = 1001L;
    protected String nrOfSapwoodRings;
    protected TridasLastRingUnderBark lastRingUnderBark;
    protected String missingSapwoodRingsToBark;
    protected String missingSapwoodRingsToBarkFoundation;
    @XmlAttribute(name = "presence", required = true)
    protected ComplexPresenceAbsence presence;

    /**
     * Gets the value of the nrOfSapwoodRings property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNrOfSapwoodRings() {
        return nrOfSapwoodRings;
    }

    /**
     * Sets the value of the nrOfSapwoodRings property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNrOfSapwoodRings(String value) {
        this.nrOfSapwoodRings = value;
    }

    public boolean isSetNrOfSapwoodRings() {
        return (this.nrOfSapwoodRings!= null);
    }

    /**
     * Gets the value of the lastRingUnderBark property.
     * 
     * @return
     *     possible object is
     *     {@link TridasLastRingUnderBark }
     *     
     */
    public TridasLastRingUnderBark getLastRingUnderBark() {
        return lastRingUnderBark;
    }

    /**
     * Sets the value of the lastRingUnderBark property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasLastRingUnderBark }
     *     
     */
    public void setLastRingUnderBark(TridasLastRingUnderBark value) {
        this.lastRingUnderBark = value;
    }

    public boolean isSetLastRingUnderBark() {
        return (this.lastRingUnderBark!= null);
    }

    /**
     * Gets the value of the missingSapwoodRingsToBark property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissingSapwoodRingsToBark() {
        return missingSapwoodRingsToBark;
    }

    /**
     * Sets the value of the missingSapwoodRingsToBark property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissingSapwoodRingsToBark(String value) {
        this.missingSapwoodRingsToBark = value;
    }

    public boolean isSetMissingSapwoodRingsToBark() {
        return (this.missingSapwoodRingsToBark!= null);
    }

    /**
     * Gets the value of the missingSapwoodRingsToBarkFoundation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMissingSapwoodRingsToBarkFoundation() {
        return missingSapwoodRingsToBarkFoundation;
    }

    /**
     * Sets the value of the missingSapwoodRingsToBarkFoundation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMissingSapwoodRingsToBarkFoundation(String value) {
        this.missingSapwoodRingsToBarkFoundation = value;
    }

    public boolean isSetMissingSapwoodRingsToBarkFoundation() {
        return (this.missingSapwoodRingsToBarkFoundation!= null);
    }

    /**
     * Gets the value of the presence property.
     * 
     * @return
     *     possible object is
     *     {@link ComplexPresenceAbsence }
     *     
     */
    public ComplexPresenceAbsence getPresence() {
        return presence;
    }

    /**
     * Sets the value of the presence property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComplexPresenceAbsence }
     *     
     */
    public void setPresence(ComplexPresenceAbsence value) {
        this.presence = value;
    }

    public boolean isSetPresence() {
        return (this.presence!= null);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
