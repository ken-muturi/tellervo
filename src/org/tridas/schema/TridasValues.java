//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.26 at 05:22:23 PM PDT 
//


package org.tridas.schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.tridas.annotations.TridasEditProperties;


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
 *         &lt;element ref="{http://www.tridas.org/1.2}variable"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.tridas.org/1.2}unitless"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}unit"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.tridas.org/1.2}value" maxOccurs="unbounded"/>
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
    "variable",
    "unit",
    "unitless",
    "values"
})
@XmlRootElement(name = "values")
@TridasEditProperties(machineOnly = true)
public class TridasValues
    implements Serializable
{

    private final static long serialVersionUID = 1001L;
    @XmlElement(required = true)
    protected TridasVariable variable;
    protected TridasUnit unit;
    protected TridasUnitless unitless;
    @XmlElement(name = "value", required = true)
    protected List<TridasValue> values;

    /**
     * Gets the value of the variable property.
     * 
     * @return
     *     possible object is
     *     {@link TridasVariable }
     *     
     */
    public TridasVariable getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasVariable }
     *     
     */
    public void setVariable(TridasVariable value) {
        this.variable = value;
    }

    public boolean isSetVariable() {
        return (this.variable!= null);
    }

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link TridasUnit }
     *     
     */
    public TridasUnit getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasUnit }
     *     
     */
    public void setUnit(TridasUnit value) {
        this.unit = value;
    }

    public boolean isSetUnit() {
        return (this.unit!= null);
    }

    /**
     * Gets the value of the unitless property.
     * 
     * @return
     *     possible object is
     *     {@link TridasUnitless }
     *     
     */
    public TridasUnitless getUnitless() {
        return unitless;
    }

    /**
     * Sets the value of the unitless property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasUnitless }
     *     
     */
    public void setUnitless(TridasUnitless value) {
        this.unitless = value;
    }

    public boolean isSetUnitless() {
        return (this.unitless!= null);
    }

    /**
     * Gets the value of the values property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the values property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValues().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasValue }
     * 
     * 
     */
    public List<TridasValue> getValues() {
        if (values == null) {
            values = new ArrayList<TridasValue>();
        }
        return this.values;
    }

    public boolean isSetValues() {
        return ((this.values!= null)&&(!this.values.isEmpty()));
    }

    public void unsetValues() {
        this.values = null;
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
