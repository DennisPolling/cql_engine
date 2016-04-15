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
import javax.xml.bind.annotation.XmlAttribute;
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
 * The In operator tests for membership in an interval or list.
 * 			
 * There are two overloads of this operator:
 * 	T, List : The type of T must be the same as the element type of the list.
 * 	T, Interval : The type of T must be the same as the point type of the interval.
 * 	
 * For the T, List overload, this operator returns true if the given element is in the given list, using equivalence semantics.
 * 
 * For the T, Interval overload, this operator returns true if the given point is greater than or equal to the starting point of the interval, and less than or equal to the ending point of the interval. For open interval boundaries, exclusive comparison operators are used. For closed interval boundaries, if the interval boundary is null, the result of the boundary comparison is considered true.
 * 
 * If either argument is null, the result is null.
 * 
 * <p>Java class for In complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="In"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}BinaryExpression"&gt;
 *       &lt;attribute name="precision" type="{urn:hl7-org:elm:r1}DateTimePrecision" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "In", namespace = "urn:hl7-org:elm:r1")
public class In
    extends BinaryExpression
    implements Equals, HashCode, ToString
{

    @XmlAttribute(name = "precision")
    protected DateTimePrecision precision;

    /**
     * Gets the value of the precision property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimePrecision }
     *     
     */
    public DateTimePrecision getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimePrecision }
     *     
     */
    public void setPrecision(DateTimePrecision value) {
        this.precision = value;
    }

    public In withPrecision(DateTimePrecision value) {
        setPrecision(value);
        return this;
    }

    @Override
    public In withOperand(Expression... values) {
        if (values!= null) {
            for (Expression value: values) {
                getOperand().add(value);
            }
        }
        return this;
    }

    @Override
    public In withOperand(Collection<Expression> values) {
        if (values!= null) {
            getOperand().addAll(values);
        }
        return this;
    }

    @Override
    public In withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public In withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public In withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof In)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final In that = ((In) object);
        {
            DateTimePrecision lhsPrecision;
            lhsPrecision = this.getPrecision();
            DateTimePrecision rhsPrecision;
            rhsPrecision = that.getPrecision();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "precision", lhsPrecision), LocatorUtils.property(thatLocator, "precision", rhsPrecision), lhsPrecision, rhsPrecision)) {
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
            DateTimePrecision thePrecision;
            thePrecision = this.getPrecision();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "precision", thePrecision), currentHashCode, thePrecision);
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
            DateTimePrecision thePrecision;
            thePrecision = this.getPrecision();
            strategy.appendField(locator, this, "precision", buffer, thePrecision);
        }
        return buffer;
    }

}
