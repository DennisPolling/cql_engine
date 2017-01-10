package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;

/*
ToInteger(argument String) Integer

The ToInteger operator converts the value of its argument to an Integer value.
The operator accepts strings using the following format:
  (+|-)?#0
Meaning an optional polarity indicator, followed by any number of digits (including none), followed by at least one digit.
Note that the integer value returned by this operator must be a valid value in the range representable for Integer values in CQL.
If the input string is not formatted correctly, or cannot be interpreted as a valid Integer value, a run-time error is thrown.
If the argument is null, the result is null.
*/

/**
* Created by Chris Schuler on 6/14/2016
*/
public class ToIntegerEvaluator extends org.cqframework.cql.elm.execution.ToInteger {

  @Override
  public Object doOperation(String operand) {
    try {
      return Integer.parseInt(operand);
    }
    catch (NumberFormatException nfe) {
      throw new NumberFormatException("Unable to convert given string to Integer");
    }
  }

  @Override
  public Object evaluate(Context context) {
    Object operand = getOperand().evaluate(context);

    if (operand == null) { return null; }

    return Execution.resolveTypeDoOperation(this, operand);
  }
}
