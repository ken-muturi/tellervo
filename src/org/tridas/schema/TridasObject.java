//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-793 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.06.25 at 12:38:10 PM PDT 
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
import edu.cornell.dendro.corina.tridasv2.TridasObjectEx;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * 
 * An object is the item to be investigated.  Examples include: violin; excavation site; 
 * painting on a wooden panel; water well; church; carving; ship; forest. An object could 
 * also be more specific, for example: mast of a ship; roof of a church. Depending on the 
 * object type various descriptions are made possible. An object can have one or more 
 * elements and can also refer to another (sub) object.  For instance a single file 
 * may contain three objects: an archaeological site object, within which there is a 
 * building object, within which there is a beam object.  The list of possible object 
 * types is extensible and is thus flexible enough to incorporate the diversity of data 
 * required by the dendro community.  Only information that is essential for 
 * dendrochronological research is recorded here. Other related data may be provided in the 
 * form of a link to an external database such as a museum catalogue. 
 * 			
 * 
 * <p>Java class for object element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="object">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;extension base="{http://www.tridas.org/1.2}tridasEntity">
 *         &lt;sequence>
 *           &lt;element ref="{http://www.tridas.org/1.2}type"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}description" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}linkSeries" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}file" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}creator" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}owner" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}coverage" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}location" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}genericField" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}object" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element ref="{http://www.tridas.org/1.2}element" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/extension>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "type",
    "description",
    "linkSeries",
    "files",
    "creator",
    "owner",
    "coverage",
    "location",
    "genericFields",
    "objects",
    "elements"
})
@XmlRootElement(name = "object")
public class TridasObject
    extends TridasEntity
    implements Serializable
{

    @XmlElement(required = true)
    protected ControlledVoc type;
    protected String description;
    protected TridasLinkSeries linkSeries;
    @XmlElement(name = "file")
    protected List<TridasFile> files;
    protected String creator;
    protected String owner;
    protected TridasCoverage coverage;
    protected TridasLocation location;
    @XmlElement(name = "genericField")
    protected List<TridasGenericField> genericFields;
    @XmlElement(name = "object", type = TridasObjectEx.class)
    protected List<TridasObject> objects;
    @XmlElement(name = "element")
    protected List<TridasElement> elements;

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
     * Gets the value of the files property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the files property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasFile }
     * 
     * 
     */
    public List<TridasFile> getFiles() {
        if (files == null) {
            files = new ArrayList<TridasFile>();
        }
        return this.files;
    }

    public boolean isSetFiles() {
        return ((this.files!= null)&&(!this.files.isEmpty()));
    }

    public void unsetFiles() {
        this.files = null;
    }

    /**
     * Gets the value of the creator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Sets the value of the creator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreator(String value) {
        this.creator = value;
    }

    public boolean isSetCreator() {
        return (this.creator!= null);
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    public boolean isSetOwner() {
        return (this.owner!= null);
    }

    /**
     * Gets the value of the coverage property.
     * 
     * @return
     *     possible object is
     *     {@link TridasCoverage }
     *     
     */
    public TridasCoverage getCoverage() {
        return coverage;
    }

    /**
     * Sets the value of the coverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TridasCoverage }
     *     
     */
    public void setCoverage(TridasCoverage value) {
        this.coverage = value;
    }

    public boolean isSetCoverage() {
        return (this.coverage!= null);
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
     * Gets the value of the genericFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGenericFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasGenericField }
     * 
     * 
     */
    public List<TridasGenericField> getGenericFields() {
        if (genericFields == null) {
            genericFields = new ArrayList<TridasGenericField>();
        }
        return this.genericFields;
    }

    public boolean isSetGenericFields() {
        return ((this.genericFields!= null)&&(!this.genericFields.isEmpty()));
    }

    public void unsetGenericFields() {
        this.genericFields = null;
    }

    /**
     * Gets the value of the objects property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objects property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjects().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasObject }
     * 
     * 
     */
    public List<TridasObject> getObjects() {
        if (objects == null) {
            objects = new ArrayList<TridasObject>();
        }
        return this.objects;
    }

    public boolean isSetObjects() {
        return ((this.objects!= null)&&(!this.objects.isEmpty()));
    }

    public void unsetObjects() {
        this.objects = null;
    }

    /**
     * Gets the value of the elements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasElement }
     * 
     * 
     */
    public List<TridasElement> getElements() {
        if (elements == null) {
            elements = new ArrayList<TridasElement>();
        }
        return this.elements;
    }

    public boolean isSetElements() {
        return ((this.elements!= null)&&(!this.elements.isEmpty()));
    }

    public void unsetElements() {
        this.elements = null;
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
