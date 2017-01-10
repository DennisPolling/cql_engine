package org.opencds.cqf.cql.elm.execution;

import org.opencds.cqf.cql.execution.Context;

/*
Last(argument List<T>) T

The Last operator returns the last element in a list. In a list of length N, the operator
  is equivalent to invoking the indexer with an index of N - 1.
If the argument is null, the result is null.
*/

/**
 * Created by Bryn on 5/25/2016.
 */
public class LastEvaluator extends org.cqframework.cql.elm.execution.Last {

    @Override
    public Object doOperation(Iterable<Object> operand) {
        Object result = null;
        for (Object element : operand) {
            result = element;
        }

        return result;
    }

    @Override
    public Object evaluate(Context context) {
        Object operand = getSource().evaluate(context);

        if (operand == null) { return null; }

        return Execution.resolveListDoOperation(this, operand);
    }
}
