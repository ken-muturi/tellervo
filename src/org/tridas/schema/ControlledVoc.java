//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.04 at 11:54:16 AM PDT 
//


package org.tridas.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * 
 * 				A controlled vocabulary is used to limit users to a pick list of values
 * 			
 * 
 * <p>Java class for controlledVoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="controlledVoc">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="normalStd" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="normalId" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="normal" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "controlledVoc", propOrder = {
    "value"
})
@XmlSeeAlso({
    TridasCategory.class,
    TridasMeasuringMethod.class,
    TridasShape.class,
    TridasUnit.class,
    TridasVariable.class,
    TridasRemark.class
})
public class ControlledVoc {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "normalStd")
    @XmlSchemaType(name = "anySimpleType")
    protected String normalStd;
    @XmlAttribute(name = "normalId")
    @XmlSchemaType(name = "anySimpleType")
    protected String normalId;
    @XmlAttribute(name = "normal")
    @XmlSchemaType(name = "anySimpleType")
    protected String normal;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value!= null);
    }

    /**
     * Gets the value of the normalStd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalStd() {
        return normalStd;
    }

    /**
     * Sets the value of the normalStd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalStd(String value) {
        this.normalStd = value;
    }

    public boolean isSetNormalStd() {
        return (this.normalStd!= null);
    }

    /**
     * Gets the value of the normalId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormalId() {
        return normalId;
    }

    /**
     * Sets the value of the normalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormalId(String value) {
        this.normalId = value;
    }

    public boolean isSetNormalId() {
        return (this.normalId!= null);
    }

    /**
     * Gets the value of the normal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNormal() {
        return normal;
    }

    /**
     * Sets the value of the normal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNormal(String value) {
        this.normal = value;
    }

    public boolean isSetNormal() {
        return (this.normal!= null);
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
