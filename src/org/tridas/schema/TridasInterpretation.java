//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.27 at 01:39:39 PM PDT 
//


package org.tridas.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://www.tridas.org/1.2}firstYear" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}datingReference" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}statFoundation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}sproutYear" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}usedSoftware" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}deathYear" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}provenance" minOccurs="0"/>
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
    "firstYear",
    "datingReference",
    "statFoundation",
    "sproutYear",
    "usedSoftware",
    "deathYear",
    "provenance"
})
@XmlRootElement(name = "interpretation")
public class TridasInterpretation {

    protected Year firstYear;
    protected TridasDatingReference datingReference;
    protected List<TridasStatFoundation> statFoundation;
    protected Year sproutYear;
    protected String usedSoftware;
    protected Year deathYear;
    protected String provenance;

    /**
     * Gets the value of the firstYear property.
     * 
     * @return
     *     possible object is
     *     {@link Year }
     *     
     */
    public Year getFirstYear() {
        return firstYear;
    }

    /**
     * Sets the value of the firstYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Year }
     *     
     */
    public void setFirstYear(Year value) {
        this.firstYear = value;
    }

    public boolean isSetFirstYear() {
        return (this.firstYear!= null);
    }

    /**
     * Gets the value of the datingReference property.
     * 
     * @return
     *     possible object is
     *     {@link TridasDatingReference }
     *     
     */
    public TridasDatingReference getDatingReference() {
        return datingReference;
    }

    /**
     * Sets the value of the datingReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasDatingReference }
     *     
     */
    public void setDatingReference(TridasDatingReference value) {
        this.datingReference = value;
    }

    public boolean isSetDatingReference() {
        return (this.datingReference!= null);
    }

    /**
     * Gets the value of the statFoundation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the statFoundation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStatFoundation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasStatFoundation }
     * 
     * 
     */
    public List<TridasStatFoundation> getStatFoundation() {
        if (statFoundation == null) {
            statFoundation = new ArrayList<TridasStatFoundation>();
        }
        return this.statFoundation;
    }

    public boolean isSetStatFoundation() {
        return ((this.statFoundation!= null)&&(!this.statFoundation.isEmpty()));
    }

    public void unsetStatFoundation() {
        this.statFoundation = null;
    }

    /**
     * Gets the value of the sproutYear property.
     * 
     * @return
     *     possible object is
     *     {@link Year }
     *     
     */
    public Year getSproutYear() {
        return sproutYear;
    }

    /**
     * Sets the value of the sproutYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Year }
     *     
     */
    public void setSproutYear(Year value) {
        this.sproutYear = value;
    }

    public boolean isSetSproutYear() {
        return (this.sproutYear!= null);
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

    /**
     * Gets the value of the deathYear property.
     * 
     * @return
     *     possible object is
     *     {@link Year }
     *     
     */
    public Year getDeathYear() {
        return deathYear;
    }

    /**
     * Sets the value of the deathYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Year }
     *     
     */
    public void setDeathYear(Year value) {
        this.deathYear = value;
    }

    public boolean isSetDeathYear() {
        return (this.deathYear!= null);
    }

    /**
     * Gets the value of the provenance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvenance() {
        return provenance;
    }

    /**
     * Sets the value of the provenance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvenance(String value) {
        this.provenance = value;
    }

    public boolean isSetProvenance() {
        return (this.provenance!= null);
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
