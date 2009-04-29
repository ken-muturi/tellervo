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
 *     &lt;extension base="{http://www.tridas.org/1.2}tridasEntity">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.tridas.org/1.2}type" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}description" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}linkSeries" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}file" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}taxon"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}shape" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}dimensions" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}authenticity" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}location" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}processing" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}marks" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}altitude" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}slope" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}soil" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}bedrock" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}genericField" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tridas.org/1.2}sample" maxOccurs="unbounded" minOccurs="0"/>
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
    "type",
    "description",
    "linkSeries",
    "file",
    "taxon",
    "shape",
    "dimensions",
    "authenticity",
    "location",
    "processing",
    "marks",
    "altitude",
    "slope",
    "soil",
    "bedrock",
    "genericField",
    "sample"
})
@XmlRootElement(name = "element")
public class TridasElement
    extends TridasEntity
{

    protected ControlledVoc type;
    protected String description;
    protected TridasLinkSeries linkSeries;
    protected List<TridasFile> file;
    @XmlElement(required = true)
    protected TridasTaxon taxon;
    protected TridasShape shape;
    protected TridasDimensions dimensions;
    protected String authenticity;
    protected TridasLocation location;
    protected String processing;
    protected String marks;
    protected Double altitude;
    protected TridasSlope slope;
    protected TridasSoil soil;
    protected TridasBedrock bedrock;
    protected List<TridasGenericField> genericField;
    protected List<TridasSample> sample;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    public boolean isSetDescription() {
        return (this.description!= null);
    }

    /**
     * Gets the value of the linkSeries property.
     * 
     * @return
     *     possible object is
     *     {@link TridasLinkSeries }
     *     
     */
    public TridasLinkSeries getLinkSeries() {
        return linkSeries;
    }

    /**
     * Sets the value of the linkSeries property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasLinkSeries }
     *     
     */
    public void setLinkSeries(TridasLinkSeries value) {
        this.linkSeries = value;
    }

    public boolean isSetLinkSeries() {
        return (this.linkSeries!= null);
    }

    /**
     * Gets the value of the file property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the file property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasFile }
     * 
     * 
     */
    public List<TridasFile> getFile() {
        if (file == null) {
            file = new ArrayList<TridasFile>();
        }
        return this.file;
    }

    public boolean isSetFile() {
        return ((this.file!= null)&&(!this.file.isEmpty()));
    }

    public void unsetFile() {
        this.file = null;
    }

    /**
     * Gets the value of the taxon property.
     * 
     * @return
     *     possible object is
     *     {@link TridasTaxon }
     *     
     */
    public TridasTaxon getTaxon() {
        return taxon;
    }

    /**
     * Sets the value of the taxon property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasTaxon }
     *     
     */
    public void setTaxon(TridasTaxon value) {
        this.taxon = value;
    }

    public boolean isSetTaxon() {
        return (this.taxon!= null);
    }

    /**
     * Gets the value of the shape property.
     * 
     * @return
     *     possible object is
     *     {@link TridasShape }
     *     
     */
    public TridasShape getShape() {
        return shape;
    }

    /**
     * Sets the value of the shape property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasShape }
     *     
     */
    public void setShape(TridasShape value) {
        this.shape = value;
    }

    public boolean isSetShape() {
        return (this.shape!= null);
    }

    /**
     * Gets the value of the dimensions property.
     * 
     * @return
     *     possible object is
     *     {@link TridasDimensions }
     *     
     */
    public TridasDimensions getDimensions() {
        return dimensions;
    }

    /**
     * Sets the value of the dimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasDimensions }
     *     
     */
    public void setDimensions(TridasDimensions value) {
        this.dimensions = value;
    }

    public boolean isSetDimensions() {
        return (this.dimensions!= null);
    }

    /**
     * Gets the value of the authenticity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticity() {
        return authenticity;
    }

    /**
     * Sets the value of the authenticity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticity(String value) {
        this.authenticity = value;
    }

    public boolean isSetAuthenticity() {
        return (this.authenticity!= null);
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link TridasLocation }
     *     
     */
    public TridasLocation getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasLocation }
     *     
     */
    public void setLocation(TridasLocation value) {
        this.location = value;
    }

    public boolean isSetLocation() {
        return (this.location!= null);
    }

    /**
     * Gets the value of the processing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessing() {
        return processing;
    }

    /**
     * Sets the value of the processing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessing(String value) {
        this.processing = value;
    }

    public boolean isSetProcessing() {
        return (this.processing!= null);
    }

    /**
     * Gets the value of the marks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarks() {
        return marks;
    }

    /**
     * Sets the value of the marks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarks(String value) {
        this.marks = value;
    }

    public boolean isSetMarks() {
        return (this.marks!= null);
    }

    /**
     * Gets the value of the altitude property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Sets the value of the altitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAltitude(Double value) {
        this.altitude = value;
    }

    public boolean isSetAltitude() {
        return (this.altitude!= null);
    }

    /**
     * Gets the value of the slope property.
     * 
     * @return
     *     possible object is
     *     {@link TridasSlope }
     *     
     */
    public TridasSlope getSlope() {
        return slope;
    }

    /**
     * Sets the value of the slope property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasSlope }
     *     
     */
    public void setSlope(TridasSlope value) {
        this.slope = value;
    }

    public boolean isSetSlope() {
        return (this.slope!= null);
    }

    /**
     * Gets the value of the soil property.
     * 
     * @return
     *     possible object is
     *     {@link TridasSoil }
     *     
     */
    public TridasSoil getSoil() {
        return soil;
    }

    /**
     * Sets the value of the soil property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasSoil }
     *     
     */
    public void setSoil(TridasSoil value) {
        this.soil = value;
    }

    public boolean isSetSoil() {
        return (this.soil!= null);
    }

    /**
     * Gets the value of the bedrock property.
     * 
     * @return
     *     possible object is
     *     {@link TridasBedrock }
     *     
     */
    public TridasBedrock getBedrock() {
        return bedrock;
    }

    /**
     * Sets the value of the bedrock property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasBedrock }
     *     
     */
    public void setBedrock(TridasBedrock value) {
        this.bedrock = value;
    }

    public boolean isSetBedrock() {
        return (this.bedrock!= null);
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
     * Gets the value of the sample property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sample property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSample().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasSample }
     * 
     * 
     */
    public List<TridasSample> getSample() {
        if (sample == null) {
            sample = new ArrayList<TridasSample>();
        }
        return this.sample;
    }

    public boolean isSetSample() {
        return ((this.sample!= null)&&(!this.sample.isEmpty()));
    }

    public void unsetSample() {
        this.sample = null;
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
