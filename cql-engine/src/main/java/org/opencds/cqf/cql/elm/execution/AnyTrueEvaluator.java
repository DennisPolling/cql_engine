package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;

import java.util.Iterator;

/*
AnyTrue(argument List<Boolean>) Boolean

The AnyTrue operator returns true if any non-null element in the source is true.
If the source contains no non-null elements, false is returned.
If the source is null, the result is null.
*/

/**
 * Created by Bryn on 5/25/2016.
 */
public class AnyTrueEvaluator extends org.cqframework.cql.elm.execution.AnyTrue {

    @Override
    public Object doOperation(Iterable<Object> operand) {
        Iterator<Object> elemsItr = operand.iterator();

        if (!elemsItr.hasNext()) { return null; } // empty list

        while (elemsItr.hasNext()) {
            Object exp = elemsItr.next();
            if (exp == null) { continue; } // skip null
            Boolean boolVal = (Boolean) exp;
            if (Boolean.TRUE == boolVal) return true;
        }

        return false; // all null or all false
    }

    @Override
    public Object evaluate(Context context) {
        Object operand = getSource().evaluate(context);

        // The list may contain all nulls for this list operator
        if (operand == null) { return null; }

        return Execution.resolveAggregateDoOperation(this, operand);
    }
}
