package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;

import java.math.BigDecimal;

/*
ToDecimal(argument String) Decimal

The ToDecimal operator converts the value of its argument to a Decimal value.
The operator accepts strings using the following format:
  (+|-)?#0(.0#)?
Meaning an optional polarity indicator, followed by any number of digits (including none), followed by at least one digit,
  followed optionally by a decimal point, at least one digit, and any number of additional digits (including none).
Note that the decimal value returned by this operator must be limited in precision and scale to the maximum precision and
  scale representable for Decimal values within CQL.
If the input string is not formatted correctly, or cannot be interpreted as a valid Decimal value, a run-time error is thrown.
If the argument is null, the result is null.
*/

/**
 * Created by Bryn on 5/25/2016.
 */
public class ToDecimalEvaluator extends org.cqframework.cql.elm.execution.ToDecimal {

    @Override
    public Object doOperation(String operand) {
        try {
            return new BigDecimal(operand);
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Unable to convert given string to Decimal");
        }
    }

    // NOTE: the following method signature is not part of the spec
    // this is used for implicit conversions to decimal
    @Override
    public Object doOperation(Integer operand) {
        return new BigDecimal(operand);
    }

    @Override
    public Object evaluate(Context context) {
        Object operand = getOperand().evaluate(context);

        if (operand == null) { return null; }

        return Execution.resolveTypeDoOperation(this, operand);
    }
}
