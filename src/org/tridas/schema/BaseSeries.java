//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.04.29 at 01:11:36 PM PDT 
//


package org.tridas.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * <p>Java class for baseSeries complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseSeries">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.tridas.org/1.2}tridasEntity">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.tridas.org/1.2}pithAndSapwoodInfo" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}analyst" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}dendrochronologist" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}measuringMethod" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}type" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}linkSeries" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}objective" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}standardizingMethod" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}author" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}version" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}comments" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}usage" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}usageComments" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;group ref="{http://www.tridas.org/1.2}interpretationType" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}extent" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}genericField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}values" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseSeries", propOrder = {
    "pithAndSapwoodInfo",
    "analyst",
    "dendrochronologist",
    "measuringMethod",
    "type",
    "linkSeries",
    "objective",
    "standardizingMethod",
    "author",
    "version",
    "comments",
    "usage",
    "usageComments",
    "interpretation",
    "interpretationUnsolved",
    "extent",
    "genericField",
    "values"
})
@XmlSeeAlso({
    TridasDerivedSeries.class,
    TridasMeasurementSeries.class
})
public abstract class BaseSeries
    extends TridasEntity
{

    protected TridasPithAndSapwoodInfo pithAndSapwoodInfo;
    protected String analyst;
    protected String dendrochronologist;
    protected TridasMeasuringMethod measuringMethod;
    protected ControlledVoc type;
    protected List<TridasLinkSeries> linkSeries;
    protected String objective;
    protected String standardizingMethod;
    protected String author;
    protected String version;
    protected String comments;
    protected String usage;
    protected List<String> usageComments;
    protected TridasInterpretation interpretation;
    protected String interpretationUnsolved;
    protected TridasExtent extent;
    protected List<TridasGenericField> genericField;
    protected List<TridasValues> values;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

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
     * Gets the value of the analyst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnalyst() {
        return analyst;
    }

    /**
     * Sets the value of the analyst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnalyst(String value) {
        this.analyst = value;
    }

    public boolean isSetAnalyst() {
        return (this.analyst!= null);
    }

    /**
     * Gets the value of the dendrochronologist property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDendrochronologist() {
        return dendrochronologist;
    }

    /**
     * Sets the value of the dendrochronologist property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDendrochronologist(String value) {
        this.dendrochronologist = value;
    }

    public boolean isSetDendrochronologist() {
        return (this.dendrochronologist!= null);
    }

    /**
     * Gets the value of the measuringMethod property.
     * 
     * @return
     *     possible object is
     *     {@link TridasMeasuringMethod }
     *     
     */
    public TridasMeasuringMethod getMeasuringMethod() {
        return measuringMethod;
    }

    /**
     * Sets the value of the measuringMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasMeasuringMethod }
     *     
     */
    public void setMeasuringMethod(TridasMeasuringMethod value) {
        this.measuringMethod = value;
    }

    public boolean isSetMeasuringMethod() {
        return (this.measuringMethod!= null);
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
     * Gets the value of the linkSeries property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkSeries property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkSeries().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasLinkSeries }
     * 
     * 
     */
    public List<TridasLinkSeries> getLinkSeries() {
        if (linkSeries == null) {
            linkSeries = new ArrayList<TridasLinkSeries>();
        }
        return this.linkSeries;
    }

    public boolean isSetLinkSeries() {
        return ((this.linkSeries!= null)&&(!this.linkSeries.isEmpty()));
    }

    public void unsetLinkSeries() {
        this.linkSeries = null;
    }

    /**
     * Gets the value of the objective property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjective() {
        return objective;
    }

    /**
     * Sets the value of the objective property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjective(String value) {
        this.objective = value;
    }

    public boolean isSetObjective() {
        return (this.objective!= null);
    }

    /**
     * Gets the value of the standardizingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandardizingMethod() {
        return standardizingMethod;
    }

    /**
     * Sets the value of the standardizingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandardizingMethod(String value) {
        this.standardizingMethod = value;
    }

    public boolean isSetStandardizingMethod() {
        return (this.standardizingMethod!= null);
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    public boolean isSetAuthor() {
        return (this.author!= null);
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    public boolean isSetVersion() {
        return (this.version!= null);
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComments(String value) {
        this.comments = value;
    }

    public boolean isSetComments() {
        return (this.comments!= null);
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
    }

    public boolean isSetUsage() {
        return (this.usage!= null);
    }

    /**
     * Gets the value of the usageComments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usageComments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsageComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUsageComments() {
        if (usageComments == null) {
            usageComments = new ArrayList<String>();
        }
        return this.usageComments;
    }

    public boolean isSetUsageComments() {
        return ((this.usageComments!= null)&&(!this.usageComments.isEmpty()));
    }

    public void unsetUsageComments() {
        this.usageComments = null;
    }

    /**
     * Gets the value of the interpretation property.
     * 
     * @return
     *     possible object is
     *     {@link TridasInterpretation }
     *     
     */
    public TridasInterpretation getInterpretation() {
        return interpretation;
    }

    /**
     * Sets the value of the interpretation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasInterpretation }
     *     
     */
    public void setInterpretation(TridasInterpretation value) {
        this.interpretation = value;
    }

    public boolean isSetInterpretation() {
        return (this.interpretation!= null);
    }

    /**
     * Gets the value of the interpretationUnsolved property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpretationUnsolved() {
        return interpretationUnsolved;
    }

    /**
     * Sets the value of the interpretationUnsolved property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpretationUnsolved(String value) {
        this.interpretationUnsolved = value;
    }

    public boolean isSetInterpretationUnsolved() {
        return (this.interpretationUnsolved!= null);
    }

    /**
     * Gets the value of the extent property.
     * 
     * @return
     *     possible object is
     *     {@link TridasExtent }
     *     
     */
    public TridasExtent getExtent() {
        return extent;
    }

    /**
     * Sets the value of the extent property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasExtent }
     *     
     */
    public void setExtent(TridasExtent value) {
        this.extent = value;
    }

    public boolean isSetExtent() {
        return (this.extent!= null);
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
     * {@link TridasValues }
     * 
     * 
     */
    public List<TridasValues> getValues() {
        if (values == null) {
            values = new ArrayList<TridasValues>();
        }
        return this.values;
    }

    public boolean isSetValues() {
        return ((this.values!= null)&&(!this.values.isEmpty()));
    }

    public void unsetValues() {
        this.values = null;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
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
