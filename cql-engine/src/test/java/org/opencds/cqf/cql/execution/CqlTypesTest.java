package org.opencds.cqf.cql.execution;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.opencds.cqf.cql.runtime.*;
import java.math.BigDecimal;
import org.joda.time.Partial;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.bind.JAXBException;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.comparesEqualTo;

public class CqlTypesTest extends CqlExecutionTestBase {

    @Test
    public void testAny() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("AnyInteger").getExpression().evaluate(context);
        assertThat(result, is(new Integer(5)));

        result = context.resolveExpressionRef("AnyDecimal").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("5.0")));

        result = context.resolveExpressionRef("AnyQuantity").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("5.0")).withUnit("g")));

        result = context.resolveExpressionRef("AnyDateTime").getExpression().evaluate(context);
        assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(3), new int[] {2012, 4, 4})));

        result = context.resolveExpressionRef("AnyTime").getExpression().evaluate(context);
        assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {9, 0, 0, 0})));

        result = context.resolveExpressionRef("AnyInterval").getExpression().evaluate(context);
        assertThat(((Interval)result).equal(new Interval(2, true, 7, true)), is(true));

        result = context.resolveExpressionRef("AnyList").getExpression().evaluate(context);
        assertThat(result, is(Arrays.asList(1, 2, 3)));

        result = context.resolveExpressionRef("AnyTuple").getExpression().evaluate(context);
        assertThat(((Tuple)result).getElements(), is(new HashMap<String, Object>() {{put("id", 5); put("name", "Chris");}}));

        result = context.resolveExpressionRef("AnyString").getExpression().evaluate(context);
        assertThat(result, is("Chris"));
    }

    @Test
    public void testBoolean() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("BooleanTestTrue").getExpression().evaluate(context);
        assertThat(result.getClass().getSimpleName(), is("Boolean"));
        assertThat(result, is(true));

        result = context.resolveExpressionRef("BooleanTestFalse").getExpression().evaluate(context);
        assertThat(result.getClass().getSimpleName(), is("Boolean"));
        assertThat(result, is(false));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Code#evaluate(Context)}
     */
    @Test
    public void testCode() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("CodeLiteral").getExpression().evaluate(context);
        assertThat(result, is(new Code().withCode("8480-6").withSystem("http://loinc.org").withDisplay("Systolic blood pressure")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Concept#evaluate(Context)}
     */
    @Test
    public void testConcept() throws JAXBException {
      Context context = new Context(library);
      Object result = context.resolveExpressionRef("ConceptTest").getExpression().evaluate(context);
      assertThat(result, is(new Concept().withCodes(Arrays.asList(new Code().withCode("66071002").withSystem("http://loinc.org"), new Code().withCode("B18.1").withSystem("http://loinc.org"))).withDisplay("Type B viral hepatitis")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.DateTime#evaluate(Context)}
     */
    @Test
    public void testDateTime() throws JAXBException {
      Context context = new Context(library);
      Object result = context.resolveExpressionRef("DateTimeNull").getExpression().evaluate(context);
      assertThat(result, is(nullValue()));

      try {
        result = context.resolveExpressionRef("DateTimeUpperBoundExcept").getExpression().evaluate(context);
      } catch (IllegalArgumentException e) {
        assertThat(e.getMessage(), is("The year: 10000 falls above the accepted bounds of 0001-9999."));
      }

      try {
        result = context.resolveExpressionRef("DateTimeLowerBoundExcept").getExpression().evaluate(context);
      } catch (IllegalArgumentException e) {
        assertThat(e.getMessage(), is("The year: 0 falls below the accepted bounds of 0001-9999."));
      }

      result = context.resolveExpressionRef("DateTimeProper").getExpression().evaluate(context);
      assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(7), new int[] {2016, 7, 7, 6, 25, 33, 910})));

      result = context.resolveExpressionRef("DateTimeIncomplete").getExpression().evaluate(context);
      assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(3), new int[] {2015, 2, 10})));

      result = context.resolveExpressionRef("DateTimeUncertain").getExpression().evaluate(context);
      assertThat(((Uncertainty)result).getUncertaintyInterval().equal(new Interval(19, true, 49, true)), is(true));

      result = context.resolveExpressionRef("DateTimeMin").getExpression().evaluate(context);
      assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(7), new int[] {0001, 1, 1, 0, 0, 0, 0})));

      result = context.resolveExpressionRef("DateTimeMax").getExpression().evaluate(context);
      assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(7), new int[] {9999, 12, 31, 23, 59, 59, 999})));
    }

    @Test
    public void testDecimal() throws JAXBException {
        Context context = new Context(library);
        // NOTE: these should result in compile-time decimal number is too large error, but they do not...
        Object result = context.resolveExpressionRef("DecimalUpperBoundExcept").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("10000000000000000000000000000000000.00000000")));

        result = context.resolveExpressionRef("DecimalLowerBoundExcept").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("-10000000000000000000000000000000000.00000000")));

        // NOTE: This should also return an error as the fractional precision is greater than 8
        result = context.resolveExpressionRef("DecimalFractionalTooBig").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("5.999999999")));

        result = context.resolveExpressionRef("DecimalPi").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("3.14159265")));
    }

    @Test
    public void testInteger() throws JAXBException {
        Context context = new Context(library);
        Object result;
        try {
            result = context.resolveExpressionRef("IntegerLowerBoundExcept").getExpression().evaluate(context);
            Assert.fail();
        } catch (RuntimeException ignored) {}

        try {
            result = context.resolveExpressionRef("IntegerLowerBoundExcept").getExpression().evaluate(context);
            Assert.fail();
        } catch (RuntimeException ignored) {}

        result = context.resolveExpressionRef("IntegerProper").getExpression().evaluate(context);
        assertThat((Integer) result, comparesEqualTo(5000));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Quantity#evaluate(Context)}
     */
    @Test
    public void testQuantity() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("QuantityTest").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("150.2")).withUnit("lbs")));

        result = context.resolveExpressionRef("QuantityTest2").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("2.5589")).withUnit("eskimo kisses")));

        // NOTE: This should also return an error as the fractional precision is greater than 8
        result = context.resolveExpressionRef("QuantityFractionalTooBig").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("5.999999999")).withUnit("g")));
    }

    @Test
    public void testString() throws JAXBException {
        Context context = new Context(library);
        // NOTE: The escape characters (i.e. the backslashes) remain in the string...
        Object result = context.resolveExpressionRef("StringTestEscapeQuotes").getExpression().evaluate(context);
        assertThat(result, is("\\'I start with a single quote and end with a double quote\\\""));

        // NOTE: This test returns "\u0048\u0069" instead of the string equivalent "Hi"
        // TODO: perhaps "unescaping" the string should occur somewhere else...
        result = context.resolveExpressionRef("StringUnicodeTest").getExpression().evaluate(context);
        assertThat(org.apache.commons.lang3.StringEscapeUtils.unescapeJava((String)result), comparesEqualTo("Hi"));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Time#evaluate(Context)}
     */
    @Test
    public void testTime() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("TimeProper").getExpression().evaluate(context);
        assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {10, 25, 12, 863})));

        result = context.resolveExpressionRef("TimeAllMax").getExpression().evaluate(context);
        assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {23, 59, 59, 999})));

        result = context.resolveExpressionRef("TimeAllMin").getExpression().evaluate(context);
        assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {0, 0, 0, 0})));
    }
}
