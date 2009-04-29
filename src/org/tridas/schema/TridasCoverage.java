//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.29 at 01:11:36 PM PDT 
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
 *         &lt;element ref="{http://www.tridas.org/1.2}coverageTemporal"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}coverageTemporalFoundation"/>
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
    "coverageTemporal",
    "coverageTemporalFoundation"
})
@XmlRootElement(name = "coverage")
public class TridasCoverage {

    @XmlElement(required = true)
    protected String coverageTemporal;
    @XmlElement(required = true)
    protected String coverageTemporalFoundation;

    /**
     * Gets the value of the coverageTemporal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverageTemporal() {
        return coverageTemporal;
    }

    /**
     * Sets the value of the coverageTemporal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverageTemporal(String value) {
        this.coverageTemporal = value;
    }

    public boolean isSetCoverageTemporal() {
        return (this.coverageTemporal!= null);
    }

    /**
     * Gets the value of the coverageTemporalFoundation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverageTemporalFoundation() {
        return coverageTemporalFoundation;
    }

    /**
     * Sets the value of the coverageTemporalFoundation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverageTemporalFoundation(String value) {
        this.coverageTemporalFoundation = value;
    }

    public boolean isSetCoverageTemporalFoundation() {
        return (this.coverageTemporalFoundation!= null);
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
