package org.opencds.cqf.cql.runtime;

import java.math.BigDecimal;

/**
 * Created by Bryn on 4/15/2016.
 */
public class Quantity {
    private BigDecimal value;
    public BigDecimal getValue() {
        return value;
    }
    public void setValue(BigDecimal value) {
        this.value = value;
    }
    public Quantity withValue(BigDecimal value) {
        setValue(value);
        return this;
    }

    private String unit;
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public Quantity withUnit(String unit) {
        setUnit(unit);
        return this;
    }

    public Integer compareTo(Quantity other) {
        return this.getValue().compareTo(other.getValue());
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Quantity)) {
            return false;
        }

        Quantity otherQuantity = (Quantity)other;
        return value.compareTo(otherQuantity.getValue()) == 0
                && ((unit == null && otherQuantity.getUnit() == null) || unit.equals(otherQuantity.getUnit()));
    }
}
