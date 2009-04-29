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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *         &lt;element ref="{http://www.tridas.org/1.2}unit"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element name="diameter" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *             &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *           &lt;/sequence>
 *           &lt;sequence>
 *             &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *             &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *             &lt;element name="depth" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *           &lt;/sequence>
 *         &lt;/choice>
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
    "content"
})
@XmlRootElement(name = "dimensions")
public class TridasDimensions {

    @XmlElementRefs({
        @XmlElementRef(name = "width", namespace = "http://www.tridas.org/1.2", type = JAXBElement.class),
        @XmlElementRef(name = "depth", namespace = "http://www.tridas.org/1.2", type = JAXBElement.class),
        @XmlElementRef(name = "height", namespace = "http://www.tridas.org/1.2", type = JAXBElement.class),
        @XmlElementRef(name = "unit", namespace = "http://www.tridas.org/1.2", type = TridasUnit.class),
        @XmlElementRef(name = "diameter", namespace = "http://www.tridas.org/1.2", type = JAXBElement.class)
    })
    protected List<Object> content;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Height" is used by two different parts of a schema. See: 
     * line 490 of file:/S:/workspaces/dendro/Corina-dev/src/edu/cornell/dendro/webservice/schemas/tridas.xsd
     * line 487 of file:/S:/workspaces/dendro/Corina-dev/src/edu/cornell/dendro/webservice/schemas/tridas.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * {@link TridasUnit }
     * {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
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
