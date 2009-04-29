//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.29 at 01:23:19 PM PDT 
//


package org.tridas.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://www.tridas.org/1.2}pith"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}heartwood"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}sapwood"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}bark"/>
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
    "pith",
    "heartwood",
    "sapwood",
    "bark"
})
@XmlRootElement(name = "pithAndSapwoodInfo")
public class TridasPithAndSapwoodInfo {

    @XmlElement(required = true)
    protected TridasPith pith;
    @XmlElement(required = true)
    protected TridasHeartwood heartwood;
    @XmlElement(required = true)
    protected TridasSapwood sapwood;
    @XmlElement(required = true)
    protected TridasBark bark;

    /**
     * Gets the value of the pith property.
     * 
     * @return
     *     possible object is
     *     {@link TridasPith }
     *     
     */
    public TridasPith getPith() {
        return pith;
    }

    /**
     * Sets the value of the pith property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasPith }
     *     
     */
    public void setPith(TridasPith value) {
        this.pith = value;
    }

    public boolean isSetPith() {
        return (this.pith!= null);
    }

    /**
     * Gets the value of the heartwood property.
     * 
     * @return
     *     possible object is
     *     {@link TridasHeartwood }
     *     
     */
    public TridasHeartwood getHeartwood() {
        return heartwood;
    }

    /**
     * Sets the value of the heartwood property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasHeartwood }
     *     
     */
    public void setHeartwood(TridasHeartwood value) {
        this.heartwood = value;
    }

    public boolean isSetHeartwood() {
        return (this.heartwood!= null);
    }

    /**
     * Gets the value of the sapwood property.
     * 
     * @return
     *     possible object is
     *     {@link TridasSapwood }
     *     
     */
    public TridasSapwood getSapwood() {
        return sapwood;
    }

    /**
     * Sets the value of the sapwood property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasSapwood }
     *     
     */
    public void setSapwood(TridasSapwood value) {
        this.sapwood = value;
    }

    public boolean isSetSapwood() {
        return (this.sapwood!= null);
    }

    /**
     * Gets the value of the bark property.
     * 
     * @return
     *     possible object is
     *     {@link TridasBark }
     *     
     */
    public TridasBark getBark() {
        return bark;
    }

    /**
     * Sets the value of the bark property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasBark }
     *     
     */
    public void setBark(TridasBark value) {
        this.bark = value;
    }

    public boolean isSetBark() {
        return (this.bark!= null);
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
