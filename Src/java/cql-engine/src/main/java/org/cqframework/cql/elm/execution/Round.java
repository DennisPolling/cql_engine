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
 * The Round operator returns the nearest integer to its argument. The semantics of round are defined as a traditional round, meaning that a decimal value of 0.5 or higher will round to 1.
 * 
 * If the argument is null, the result is null.
 * 
 * Precision determines the decimal place at which the rounding will occur. If precision is not specified or null, 0 is assumed.
 * 
 * <p>Java class for Round complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Round"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}Expression"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operand" type="{urn:hl7-org:elm:r1}Expression"/&gt;
 *         &lt;element name="precision" type="{urn:hl7-org:elm:r1}Expression" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Round", namespace = "urn:hl7-org:elm:r1", propOrder = {
    "operand",
    "precision"
})
public class Round
    extends Expression
    implements Equals, HashCode, ToString
{

    @XmlElement(namespace = "urn:hl7-org:elm:r1", required = true)
    protected Expression operand;
    @XmlElement(namespace = "urn:hl7-org:elm:r1")
    protected Expression precision;

    /**
     * Gets the value of the operand property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getOperand() {
        return operand;
    }

    /**
     * Sets the value of the operand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setOperand(Expression value) {
        this.operand = value;
    }

    /**
     * Gets the value of the precision property.
     * 
     * @return
     *     possible object is
     *     {@link Expression }
     *     
     */
    public Expression getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     * 
     * @param value
     *     allowed object is
     *     {@link Expression }
     *     
     */
    public void setPrecision(Expression value) {
        this.precision = value;
    }

    public Round withOperand(Expression value) {
        setOperand(value);
        return this;
    }

    public Round withPrecision(Expression value) {
        setPrecision(value);
        return this;
    }

    @Override
    public Round withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public Round withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public Round withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Round)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final Round that = ((Round) object);
        {
            Expression lhsOperand;
            lhsOperand = this.getOperand();
            Expression rhsOperand;
            rhsOperand = that.getOperand();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operand", lhsOperand), LocatorUtils.property(thatLocator, "operand", rhsOperand), lhsOperand, rhsOperand)) {
                return false;
            }
        }
        {
            Expression lhsPrecision;
            lhsPrecision = this.getPrecision();
            Expression rhsPrecision;
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
            Expression theOperand;
            theOperand = this.getOperand();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operand", theOperand), currentHashCode, theOperand);
        }
        {
            Expression thePrecision;
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
            Expression theOperand;
            theOperand = this.getOperand();
            strategy.appendField(locator, this, "operand", buffer, theOperand);
        }
        {
            Expression thePrecision;
            thePrecision = this.getPrecision();
            strategy.appendField(locator, this, "precision", buffer, thePrecision);
        }
        return buffer;
    }

}
