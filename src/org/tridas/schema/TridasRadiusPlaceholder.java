//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.27 at 01:39:39 PM PDT 
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
 *         &lt;element ref="{http://www.tridas.org/1.2}measurementSeriesPlaceholder"/>
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
    "measurementSeriesPlaceholder"
})
@XmlRootElement(name = "radiusPlaceholder")
public class TridasRadiusPlaceholder {

    @XmlElement(required = true)
    protected TridasMeasurementSeriesPlaceholder measurementSeriesPlaceholder;

    /**
     * Gets the value of the measurementSeriesPlaceholder property.
     * 
     * @return
     *     possible object is
     *     {@link TridasMeasurementSeriesPlaceholder }
     *     
     */
    public TridasMeasurementSeriesPlaceholder getMeasurementSeriesPlaceholder() {
        return measurementSeriesPlaceholder;
    }

    /**
     * Sets the value of the measurementSeriesPlaceholder property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasMeasurementSeriesPlaceholder }
     *     
     */
    public void setMeasurementSeriesPlaceholder(TridasMeasurementSeriesPlaceholder value) {
        this.measurementSeriesPlaceholder = value;
    }

    public boolean isSetMeasurementSeriesPlaceholder() {
        return (this.measurementSeriesPlaceholder!= null);
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
