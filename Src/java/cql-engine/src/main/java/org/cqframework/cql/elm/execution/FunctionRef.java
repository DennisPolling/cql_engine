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
 * The FunctionRef type defines an expression that invokes a previously defined function. The result of evaluating each operand is passed to the function.
 * 
 * <p>Java class for FunctionRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FunctionRef"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}ExpressionRef"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operand" type="{urn:hl7-org:elm:r1}Expression" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FunctionRef", namespace = "urn:hl7-org:elm:r1", propOrder = {
    "operand"
})
public class FunctionRef
    extends ExpressionRef
    implements Equals, HashCode, ToString
{

    @XmlElement(namespace = "urn:hl7-org:elm:r1")
    protected List<Expression> operand;

    /**
     * Gets the value of the operand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Expression }
     * 
     * 
     */
    public List<Expression> getOperand() {
        if (operand == null) {
            operand = new ArrayList<Expression>();
        }
        return this.operand;
    }

    public FunctionRef withOperand(Expression... values) {
        if (values!= null) {
            for (Expression value: values) {
                getOperand().add(value);
            }
        }
        return this;
    }

    public FunctionRef withOperand(Collection<Expression> values) {
        if (values!= null) {
            getOperand().addAll(values);
        }
        return this;
    }

    @Override
    public FunctionRef withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public FunctionRef withLibraryName(String value) {
        setLibraryName(value);
        return this;
    }

    @Override
    public FunctionRef withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public FunctionRef withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public FunctionRef withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof FunctionRef)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final FunctionRef that = ((FunctionRef) object);
        {
            List<Expression> lhsOperand;
            lhsOperand = (((this.operand!= null)&&(!this.operand.isEmpty()))?this.getOperand():null);
            List<Expression> rhsOperand;
            rhsOperand = (((that.operand!= null)&&(!that.operand.isEmpty()))?that.getOperand():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "operand", lhsOperand), LocatorUtils.property(thatLocator, "operand", rhsOperand), lhsOperand, rhsOperand)) {
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
            List<Expression> theOperand;
            theOperand = (((this.operand!= null)&&(!this.operand.isEmpty()))?this.getOperand():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "operand", theOperand), currentHashCode, theOperand);
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
            List<Expression> theOperand;
            theOperand = (((this.operand!= null)&&(!this.operand.isEmpty()))?this.getOperand():null);
            strategy.appendField(locator, this, "operand", buffer, theOperand);
        }
        return buffer;
    }

}
