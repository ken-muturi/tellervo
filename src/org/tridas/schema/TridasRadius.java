//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.29 at 01:11:36 PM PDT 
//


package org.tridas.schema;

import java.math.BigDecimal;
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
 *     &lt;extension base="{http://www.tridas.org/1.2}tridasEntity">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.tridas.org/1.2}pithAndSapwoodInfo" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}azimuth" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}genericField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}measurementSeries" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pithAndSapwoodInfo",
    "azimuth",
    "genericField",
    "measurementSeries"
})
@XmlRootElement(name = "radius")
public class TridasRadius
    extends TridasEntity
{

    protected TridasPithAndSapwoodInfo pithAndSapwoodInfo;
    protected BigDecimal azimuth;
    protected List<TridasGenericField> genericField;
    protected List<TridasMeasurementSeries> measurementSeries;

    /**
     * Gets the value of the pithAndSapwoodInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TridasPithAndSapwoodInfo }
     *     
     */
    public TridasPithAndSapwoodInfo getPithAndSapwoodInfo() {
        return pithAndSapwoodInfo;
    }

    /**
     * Sets the value of the pithAndSapwoodInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasPithAndSapwoodInfo }
     *     
     */
    public void setPithAndSapwoodInfo(TridasPithAndSapwoodInfo value) {
        this.pithAndSapwoodInfo = value;
    }

    public boolean isSetPithAndSapwoodInfo() {
        return (this.pithAndSapwoodInfo!= null);
    }

    /**
     * Gets the value of the azimuth property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAzimuth() {
        return azimuth;
    }

    /**
     * Sets the value of the azimuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAzimuth(BigDecimal value) {
        this.azimuth = value;
    }

    public boolean isSetAzimuth() {
        return (this.azimuth!= null);
    }

    /**
     * Gets the value of the genericField property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericField property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasGenericField }
     * 
     * 
     */
    public List<TridasGenericField> getGenericField() {
        if (genericField == null) {
            genericField = new ArrayList<TridasGenericField>();
        }
        return this.genericField;
    }

    public boolean isSetGenericField() {
        return ((this.genericField!= null)&&(!this.genericField.isEmpty()));
    }

    public void unsetGenericField() {
        this.genericField = null;
    }

    /**
     * Gets the value of the measurementSeries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the measurementSeries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeasurementSeries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasMeasurementSeries }
     * 
     * 
     */
    public List<TridasMeasurementSeries> getMeasurementSeries() {
        if (measurementSeries == null) {
            measurementSeries = new ArrayList<TridasMeasurementSeries>();
        }
        return this.measurementSeries;
    }

    public boolean isSetMeasurementSeries() {
        return ((this.measurementSeries!= null)&&(!this.measurementSeries.isEmpty()));
    }

    public void unsetMeasurementSeries() {
        this.measurementSeries = null;
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
