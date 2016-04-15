//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.12 at 08:52:42 PM MDT 
//


package org.cqframework.cql.elm.execution;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * The Split operator splits a string into a list of strings using a separator.
 * 
 * If the stringToSplit argument is null, the result is null.
 * 
 * If the stringToSplit argument does not contain any appearances of the separator, the result is a list of strings containing one element that is the value of the stringToSplit argument.
 * 
 * <p>Java class for Split complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Split"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}Expression"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="stringToSplit" type="{urn:hl7-org:elm:r1}Expression"/&gt;
 *         &lt;element name="separator" type="{urn:hl7-org:elm:r1}Expression" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Split", namespace = "urn:hl7-org:elm:r1", propOrder = {
    "stringToSplit",
    "separator"
})
public class Split
    extends Expression
    implements Equals, HashCode, ToString
{

    @XmlElement(namespace = "urn:hl7-org:elm:r1", required = true)
    protected Expression stringToSplit;
    @XmlElement(namespace = "urn:hl7-org:elm:r1")
    protected Expression separator;

    /**
     * Gets the value of the stringToSplit property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getStringToSplit() {
        return stringToSplit;
    }

    /**
     * Sets the value of the stringToSplit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setStringToSplit(Expression value) {
        this.stringToSplit = value;
    }

    /**
     * Gets the value of the separator property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getSeparator() {
        return separator;
    }

    /**
     * Sets the value of the separator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setSeparator(Expression value) {
        this.separator = value;
    }

    public Split withStringToSplit(Expression value) {
        setStringToSplit(value);
        return this;
    }

    public Split withSeparator(Expression value) {
        setSeparator(value);
        return this;
    }

    @Override
    public Split withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public Split withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public Split withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Split)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final Split that = ((Split) object);
        {
            Expression lhsStringToSplit;
            lhsStringToSplit = this.getStringToSplit();
            Expression rhsStringToSplit;
            rhsStringToSplit = that.getStringToSplit();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "stringToSplit", lhsStringToSplit), LocatorUtils.property(thatLocator, "stringToSplit", rhsStringToSplit), lhsStringToSplit, rhsStringToSplit)) {
                return false;
            }
        }
        {
            Expression lhsSeparator;
            lhsSeparator = this.getSeparator();
            Expression rhsSeparator;
            rhsSeparator = that.getSeparator();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "separator", lhsSeparator), LocatorUtils.property(thatLocator, "separator", rhsSeparator), lhsSeparator, rhsSeparator)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            Expression theStringToSplit;
            theStringToSplit = this.getStringToSplit();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "stringToSplit", theStringToSplit), currentHashCode, theStringToSplit);
        }
        {
            Expression theSeparator;
            theSeparator = this.getSeparator();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "separator", theSeparator), currentHashCode, theSeparator);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            Expression theStringToSplit;
            theStringToSplit = this.getStringToSplit();
            strategy.appendField(locator, this, "stringToSplit", buffer, theStringToSplit);
        }
        {
            Expression theSeparator;
            theSeparator = this.getSeparator();
            strategy.appendField(locator, this, "separator", buffer, theSeparator);
        }
        return buffer;
    }

}
