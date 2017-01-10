package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;
import org.opencds.cqf.cql.runtime.DateTime;

// for Uncertainty
/*
CalculateAgeInYears(birthDate DateTime) Integer
CalculateAgeInMonths(birthDate DateTime) Integer
CalculateAgeInDays(birthDate DateTime) Integer
CalculateAgeInHours(birthDate DateTime) Integer
CalculateAgeInMinutes(birthDate DateTime) Integer
CalculateAgeInSeconds(birthDate DateTime) Integer

The CalculateAge operators calculate the age of a person born on the given birthdate as of now in the precision named in the operator.
If the birthdate is null, the result is null.
The CalculateAge operators are defined in terms of a DateTime duration calculation.
  This means that if the given birthDate is not specified to the level of precision corresponding to the operator being invoked,
    the result will be an uncertainty over the range of possible values, potentially causing some comparisons to return null.
*/

/**
* Created by Chris Schuler on 7/14/2016
*/
public class CalculateAgeEvaluator extends org.cqframework.cql.elm.execution.CalculateAge {

  @Override
  public Object doOperation(DateTime operand) {
    return new DurationBetweenEvaluator().withPrecision(getPrecision().value()).doOperation(operand, DateTime.getToday());
  }

  @Override
  public Object evaluate(Context context) {
    Object operand = getOperand().evaluate(context);

    if (operand == null) { return null; }

    return Execution.resolveClinicalDoOperation(this, operand);
  }
}
