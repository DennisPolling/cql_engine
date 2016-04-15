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
import javax.xml.bind.annotation.XmlAttribute;
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
 * The ValueSetDef type defines a value set identifier that can be referenced by name anywhere within an expression.
 * 
 * The id specifies the globally unique identifier for the value set. This may be an HL7 OID, a FHIR URL, or a CTS2 value set URL.
 * 
 * If version is specified, it will be used to resolve the version of the value set definition to be used. Otherwise, the most current published version of the value set is assumed. 
 * 
 * If codeSystems are specified, they will be used to resolve the code systems used within the value set definition to construct the expansion set.
 * Note that the recommended approach to statically binding to an expansion set is to use a value set definition that specifies the version of each code system used. The codeSystemVersions attribute is provided only to ensure static binding can be achieved when the value set definition does not specify code system versions as part of the definition header.			
 * 
 * <p>Java class for ValueSetDef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValueSetDef"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:hl7-org:elm:r1}Element"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codeSystem" type="{urn:hl7-org:elm:r1}CodeSystemRef" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="accessLevel" type="{urn:hl7-org:elm:r1}AccessModifier" default="Public" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValueSetDef", namespace = "urn:hl7-org:elm:r1", propOrder = {
    "codeSystem"
})
public class ValueSetDef
    extends Element
    implements Equals, HashCode, ToString
{

    @XmlElement(namespace = "urn:hl7-org:elm:r1")
    protected List<CodeSystemRef> codeSystem;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "accessLevel")
    protected AccessModifier accessLevel;

    /**
     * Gets the value of the codeSystem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the codeSystem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCodeSystem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeSystemRef }
     * 
     * 
     */
    public List<CodeSystemRef> getCodeSystem() {
        if (codeSystem == null) {
            codeSystem = new ArrayList<CodeSystemRef>();
        }
        return this.codeSystem;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
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

    /**
     * Gets the value of the accessLevel property.
     * 
     * @return
     *     possible object is
     *     {@link AccessModifier }
     *     
     */
    public AccessModifier getAccessLevel() {
        if (accessLevel == null) {
            return AccessModifier.PUBLIC;
        } else {
            return accessLevel;
        }
    }

    /**
     * Sets the value of the accessLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessModifier }
     *     
     */
    public void setAccessLevel(AccessModifier value) {
        this.accessLevel = value;
    }

    public ValueSetDef withCodeSystem(CodeSystemRef... values) {
        if (values!= null) {
            for (CodeSystemRef value: values) {
                getCodeSystem().add(value);
            }
        }
        return this;
    }

    public ValueSetDef withCodeSystem(Collection<CodeSystemRef> values) {
        if (values!= null) {
            getCodeSystem().addAll(values);
        }
        return this;
    }

    public ValueSetDef withName(String value) {
        setName(value);
        return this;
    }

    public ValueSetDef withId(String value) {
        setId(value);
        return this;
    }

    public ValueSetDef withVersion(String value) {
        setVersion(value);
        return this;
    }

    public ValueSetDef withAccessLevel(AccessModifier value) {
        setAccessLevel(value);
        return this;
    }

    @Override
    public ValueSetDef withAnnotation(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAnnotation().add(value);
            }
        }
        return this;
    }

    @Override
    public ValueSetDef withAnnotation(Collection<Object> values) {
        if (values!= null) {
            getAnnotation().addAll(values);
        }
        return this;
    }

    @Override
    public ValueSetDef withLocalId(String value) {
        setLocalId(value);
        return this;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ValueSetDef)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ValueSetDef that = ((ValueSetDef) object);
        {
            List<CodeSystemRef> lhsCodeSystem;
            lhsCodeSystem = (((this.codeSystem!= null)&&(!this.codeSystem.isEmpty()))?this.getCodeSystem():null);
            List<CodeSystemRef> rhsCodeSystem;
            rhsCodeSystem = (((that.codeSystem!= null)&&(!that.codeSystem.isEmpty()))?that.getCodeSystem():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "codeSystem", lhsCodeSystem), LocatorUtils.property(thatLocator, "codeSystem", rhsCodeSystem), lhsCodeSystem, rhsCodeSystem)) {
                return false;
            }
        }
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        {
            String lhsId;
            lhsId = this.getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId), LocatorUtils.property(thatLocator, "id", rhsId), lhsId, rhsId)) {
                return false;
            }
        }
        {
            String lhsVersion;
            lhsVersion = this.getVersion();
            String rhsVersion;
            rhsVersion = that.getVersion();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "version", lhsVersion), LocatorUtils.property(thatLocator, "version", rhsVersion), lhsVersion, rhsVersion)) {
                return false;
            }
        }
        {
            AccessModifier lhsAccessLevel;
            lhsAccessLevel = this.getAccessLevel();
            AccessModifier rhsAccessLevel;
            rhsAccessLevel = that.getAccessLevel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "accessLevel", lhsAccessLevel), LocatorUtils.property(thatLocator, "accessLevel", rhsAccessLevel), lhsAccessLevel, rhsAccessLevel)) {
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
            List<CodeSystemRef> theCodeSystem;
            theCodeSystem = (((this.codeSystem!= null)&&(!this.codeSystem.isEmpty()))?this.getCodeSystem():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "codeSystem", theCodeSystem), currentHashCode, theCodeSystem);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        {
            String theId;
            theId = this.getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId), currentHashCode, theId);
        }
        {
            String theVersion;
            theVersion = this.getVersion();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "version", theVersion), currentHashCode, theVersion);
        }
        {
            AccessModifier theAccessLevel;
            theAccessLevel = this.getAccessLevel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "accessLevel", theAccessLevel), currentHashCode, theAccessLevel);
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
            List<CodeSystemRef> theCodeSystem;
            theCodeSystem = (((this.codeSystem!= null)&&(!this.codeSystem.isEmpty()))?this.getCodeSystem():null);
            strategy.appendField(locator, this, "codeSystem", buffer, theCodeSystem);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            String theId;
            theId = this.getId();
            strategy.appendField(locator, this, "id", buffer, theId);
        }
        {
            String theVersion;
            theVersion = this.getVersion();
            strategy.appendField(locator, this, "version", buffer, theVersion);
        }
        {
            AccessModifier theAccessLevel;
            theAccessLevel = this.getAccessLevel();
            strategy.appendField(locator, this, "accessLevel", buffer, theAccessLevel);
        }
        return buffer;
    }

}
