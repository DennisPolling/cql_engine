//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.12 at 08:52:42 PM MDT 
//


package org.cqframework.cql.elm.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
 * TupleTypeSpecifier defines the possible elements of a tuple.
 * 
 * <p>Java class for TupleTypeSpecifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TupleTypeSpecifier"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}TypeSpecifier"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="element" type="{urn:hl7-org:elm:r1}TupleElementDefinition" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TupleTypeSpecifier", namespace = "urn:hl7-org:elm:r1", propOrder = {
    "element"
})
public class TupleTypeSpecifier
    extends TypeSpecifier
    implements Equals, HashCode, ToString
{

    @XmlElement(namespace = "urn:hl7-org:elm:r1")
    protected List<TupleElementDefinition> element;

    /**
     * Gets the value of the element property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the element property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElement().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TupleElementDefinition }
     * 
     * 
     */
    public List<TupleElementDefinition> getElement() {
        if (element == null) {
            element = new ArrayList<TupleElementDefinition>();
        }
        return this.element;
    }

    public TupleTypeSpecifier withElement(TupleElementDefinition... values) {
        if (values!= null) {
            for (TupleElementDefinition value: values) {
                getElement().add(value);
            }
        }
        return this;
    }

    public TupleTypeSpecifier withElement(Collection<TupleElementDefinition> values) {
        if (values!= null) {
            getElement().addAll(values);
        }
        return this;
    }

    @Override
    public TupleTypeSpecifier withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public TupleTypeSpecifier withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public TupleTypeSpecifier withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof TupleTypeSpecifier)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final TupleTypeSpecifier that = ((TupleTypeSpecifier) object);
        {
            List<TupleElementDefinition> lhsElement;
            lhsElement = (((this.element!= null)&&(!this.element.isEmpty()))?this.getElement():null);
            List<TupleElementDefinition> rhsElement;
            rhsElement = (((that.element!= null)&&(!that.element.isEmpty()))?that.getElement():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "element", lhsElement), LocatorUtils.property(thatLocator, "element", rhsElement), lhsElement, rhsElement)) {
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
            List<TupleElementDefinition> theElement;
            theElement = (((this.element!= null)&&(!this.element.isEmpty()))?this.getElement():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "element", theElement), currentHashCode, theElement);
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
            List<TupleElementDefinition> theElement;
            theElement = (((this.element!= null)&&(!this.element.isEmpty()))?this.getElement():null);
            strategy.appendField(locator, this, "element", buffer, theElement);
        }
        return buffer;
    }

}
