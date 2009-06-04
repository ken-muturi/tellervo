//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.04 at 11:54:16 AM PDT 
//


package org.tridas.schema;

import java.math.BigDecimal;
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
 *         &lt;element ref="{http://www.tridas.org/1.2}statValue"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}type"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}significanceLevel" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}usedSoftware"/>
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
    "statValue",
    "type",
    "significanceLevel",
    "usedSoftware"
})
@XmlRootElement(name = "statFoundation")
public class TridasStatFoundation {

    @XmlElement(required = true)
    protected BigDecimal statValue;
    @XmlElement(required = true)
    protected ControlledVoc type;
    protected BigDecimal significanceLevel;
    @XmlElement(required = true)
    protected String usedSoftware;

    /**
     * Gets the value of the statValue property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStatValue() {
        return statValue;
    }

    /**
     * Sets the value of the statValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStatValue(BigDecimal value) {
        this.statValue = value;
    }

    public boolean isSetStatValue() {
        return (this.statValue!= null);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ControlledVoc }
     *     
     */
    public ControlledVoc getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ControlledVoc }
     *     
     */
    public void setType(ControlledVoc value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the significanceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getSignificanceLevel() {
        return significanceLevel;
    }

    /**
     * Sets the value of the significanceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setSignificanceLevel(BigDecimal value) {
        this.significanceLevel = value;
    }

    public boolean isSetSignificanceLevel() {
        return (this.significanceLevel!= null);
    }

    /**
     * Gets the value of the usedSoftware property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsedSoftware() {
        return usedSoftware;
    }

    /**
     * Sets the value of the usedSoftware property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsedSoftware(String value) {
        this.usedSoftware = value;
    }

    public boolean isSetUsedSoftware() {
        return (this.usedSoftware!= null);
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
