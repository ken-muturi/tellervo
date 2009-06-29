
package org.tridas.schema;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Copyable;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.builder.CopyBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBCopyBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBEqualsBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBHashCodeBuilder;
import org.jvnet.jaxb2_commons.lang.builder.JAXBToStringBuilder;


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
 *         &lt;element ref="{http://www.tridas.org/1.2}remark" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="index" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="count" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "remarks"
})
@XmlRootElement(name = "value")
public class TridasValue
    implements Serializable, CopyTo, Copyable, Equals, HashCode, ToString
{

    private final static long serialVersionUID = 1001L;
    @XmlElement(name = "remark")
    protected List<TridasRemark> remarks;
    @XmlAttribute(required = true)
    protected String value;
    @XmlAttribute(required = true)
    protected String index;
    @XmlAttribute
    protected BigInteger count;

    /**
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TridasRemark }
     * 
     * 
     */
    public List<TridasRemark> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<TridasRemark>();
        }
        return this.remarks;
    }

    public boolean isSetRemarks() {
        return ((this.remarks!= null)&&(!this.remarks.isEmpty()));
    }

    public void unsetRemarks() {
        this.remarks = null;
    }

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
     * Gets the value of the index property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndex(String value) {
        this.index = value;
    }

    public boolean isSetIndex() {
        return (this.index!= null);
    }

    /**
     * Gets the value of the count property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCount() {
        return count;
    }

    /**
     * Sets the value of the count property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCount(BigInteger value) {
        this.count = value;
    }

    public boolean isSetCount() {
        return (this.count!= null);
    }

    public void equals(Object object, EqualsBuilder equalsBuilder) {
        if (!(object instanceof TridasValue)) {
            equalsBuilder.appendSuper(false);
            return ;
        }
        if (this == object) {
            return ;
        }
        final TridasValue that = ((TridasValue) object);
        equalsBuilder.append(this.getRemarks(), that.getRemarks());
        equalsBuilder.append(this.getValue(), that.getValue());
        equalsBuilder.append(this.getIndex(), that.getIndex());
        equalsBuilder.append(this.getCount(), that.getCount());
    }

    public boolean equals(Object object) {
        if (!(object instanceof TridasValue)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final EqualsBuilder equalsBuilder = new JAXBEqualsBuilder();
        equals(object, equalsBuilder);
        return equalsBuilder.isEquals();
    }

    public void hashCode(HashCodeBuilder hashCodeBuilder) {
        hashCodeBuilder.append(this.getRemarks());
        hashCodeBuilder.append(this.getValue());
        hashCodeBuilder.append(this.getIndex());
        hashCodeBuilder.append(this.getCount());
    }

    public int hashCode() {
        final HashCodeBuilder hashCodeBuilder = new JAXBHashCodeBuilder();
        hashCode(hashCodeBuilder);
        return hashCodeBuilder.toHashCode();
    }

    public void toString(ToStringBuilder toStringBuilder) {
        {
            List<TridasRemark> theRemarks;
            theRemarks = this.getRemarks();
            toStringBuilder.append("remarks", theRemarks);
        }
        {
            String theValue;
            theValue = this.getValue();
            toStringBuilder.append("value", theValue);
        }
        {
            String theIndex;
            theIndex = this.getIndex();
            toStringBuilder.append("index", theIndex);
        }
        {
            BigInteger theCount;
            theCount = this.getCount();
            toStringBuilder.append("count", theCount);
        }
    }

    public String toString() {
        final ToStringBuilder toStringBuilder = new JAXBToStringBuilder(this);
        toString(toStringBuilder);
        return toStringBuilder.toString();
    }

    public Object copyTo(Object target, CopyBuilder copyBuilder) {
        final TridasValue copy = ((target == null)?((TridasValue) createCopy()):((TridasValue) target));
        {
            List<TridasRemark> sourceRemarks;
            sourceRemarks = this.getRemarks();
            List<TridasRemark> copyRemarks = ((List<TridasRemark> ) copyBuilder.copy(sourceRemarks));
            copy.unsetRemarks();
            List<TridasRemark> uniqueRemarksl = copy.getRemarks();
            uniqueRemarksl.addAll(copyRemarks);
        }
        {
            String sourceValue;
            sourceValue = this.getValue();
            String copyValue = ((String) copyBuilder.copy(sourceValue));
            copy.setValue(copyValue);
        }
        {
            String sourceIndex;
            sourceIndex = this.getIndex();
            String copyIndex = ((String) copyBuilder.copy(sourceIndex));
            copy.setIndex(copyIndex);
        }
        {
            BigInteger sourceCount;
            sourceCount = this.getCount();
            BigInteger copyCount = ((BigInteger) copyBuilder.copy(sourceCount));
            copy.setCount(copyCount);
        }
        return copy;
    }

    public Object copyTo(Object target) {
        final CopyBuilder copyBuilder = new JAXBCopyBuilder();
        return copyTo(target, copyBuilder);
    }

    public Object createCopy() {
        return new TridasValue();
    }

}
