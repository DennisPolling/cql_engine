package org.opencds.cqf.cql.execution;

import org.opencds.cqf.cql.runtime.Interval;
import org.opencds.cqf.cql.runtime.Quantity;
import org.opencds.cqf.cql.runtime.DateTime;
import org.opencds.cqf.cql.runtime.Time;
import org.testng.annotations.Test;
import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.joda.time.Partial;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.instanceOf;

public class CqlArithmeticFunctionsTest extends CqlExecutionTestBase {
    /**
     * {@link org.opencds.cqf.cql.elm.execution.Abs#evaluate(Context)}
     */
    @Test
    public void testAbs() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("AbsNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Abs0").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("AbsNeg1").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("AbsNeg1Dec").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));

        result = context.resolveExpressionRef("Abs0Dec").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0.0)));

        result = context.resolveExpressionRef("Abs1cm").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("1.0")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Add#evaluate(Context)}
     */
    @Test
    public void testAdd() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("AddNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Add11").getExpression().evaluate(context);
        assertThat(result, is(2));

        result = context.resolveExpressionRef("Add1D1D").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("2.0")));

        result = context.resolveExpressionRef("Add1Q1Q").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("2.0")).withUnit("g/cm3")));

        result = context.resolveExpressionRef("AddIAndD").getExpression().evaluate(context);
        assertThat(result, is(new BigDecimal("3.0")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Ceiling#evaluate(Context)}
     */
    @Test
    public void testCeiling() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("CeilingNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Ceiling1D").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("Ceiling1D1").getExpression().evaluate(context);
        assertThat(result, is(2));

        result = context.resolveExpressionRef("CeilingNegD1").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("CeilingNeg1").getExpression().evaluate(context);
        assertThat(result, is(-1));

        result = context.resolveExpressionRef("CeilingNeg1D1").getExpression().evaluate(context);
        assertThat(result, is(-1));

        result = context.resolveExpressionRef("Ceiling1I").getExpression().evaluate(context);
        assertThat(result, is(1));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Divide#evaluate(Context)}
     */
    @Test
    public void testDivide() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("DivideNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Divide10").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Divide01").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("0.0")));

        result = context.resolveExpressionRef("Divide11").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("1.0")));

        result = context.resolveExpressionRef("Divide1d1d").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("1.0")));

        result = context.resolveExpressionRef("Divide103").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("3.33333333")));

        result = context.resolveExpressionRef("Divide1Q1").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("1.0")).withUnit("g/cm3")));

        result = context.resolveExpressionRef("Divide1Q1Q").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("1.0")).withUnit("g/cm3")));

        result = context.resolveExpressionRef("Divide10I5D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("2.0")));

        result = context.resolveExpressionRef("Divide10I5I").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("2.0")));

        result = context.resolveExpressionRef("Divide10Q5I").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("2.0")).withUnit("g")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Exp#evaluate(Context)}
     */
    @Test
    public void testExp() throws JAXBException {
        Context context = new Context(library);
        // TODO: Exp(decimal) is being evaluated as a FunctionRef, uncomment once fixed
//        Object result = context.resolveExpressionRef("ExpNull").getExpression().evaluate(context);
//        assertThat(result, is(nullValue()));
//
//        result = context.resolveExpressionRef("Exp0").getExpression().evaluate(context);
//        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));
//
//        result = context.resolveExpressionRef("ExpNeg0").getExpression().evaluate(context);
//        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));
//
//        result = context.resolveExpressionRef("Exp1").getExpression().evaluate(context);
//        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(Math.exp(1d))));
//
//        result = context.resolveExpressionRef("ExpNeg1").getExpression().evaluate(context);
//        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(Math.exp((double) -1))));
//
//        try {
//          result = context.resolveExpressionRef("Exp1000").getExpression().evaluate(context);
//        } catch (ArithmeticException ae) {
//          assertThat(ae.getMessage(), is("Results in positive infinity"));
//        }
//
//        try {
//          result = context.resolveExpressionRef("Exp1000D").getExpression().evaluate(context);
//        } catch (ArithmeticException ae) {
//          assertThat(ae.getMessage(), is("Results in positive infinity"));
//        }
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Floor#evaluate(Context)}
     */
    @Test
    public void testFloor() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("FloorNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Floor1").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("Floor1D").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("Floor1D1").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("FloorNegD1").getExpression().evaluate(context);
        assertThat(result, is(-1));

        result = context.resolveExpressionRef("FloorNeg1").getExpression().evaluate(context);
        assertThat(result, is(-1));

        result = context.resolveExpressionRef("FloorNeg1D1").getExpression().evaluate(context);
        assertThat(result, is(-2));

        result = context.resolveExpressionRef("Floor2I").getExpression().evaluate(context);
        assertThat(result, is(2));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Log#evaluate(Context)}
     */
    @Test
    public void testLog() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("LogNullNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Log1BaseNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Log1Base1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0d).setScale(8, RoundingMode.FLOOR)));

        result = context.resolveExpressionRef("Log1Base2").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0d).setScale(8, RoundingMode.FLOOR)));

        result = context.resolveExpressionRef("Log1Base100").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0d).setScale(8, RoundingMode.FLOOR)));

        result = context.resolveExpressionRef("Log16Base2").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(4d).setScale(8, RoundingMode.FLOOR)));

        result = context.resolveExpressionRef("LogD125Base2").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal((double)-3).setScale(8, RoundingMode.FLOOR)));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Ln#evaluate(Context)}
     */
    @Test
    public void testLn() throws JAXBException {
      Context context = new Context(library);
      Object result;

      result = context.resolveExpressionRef("LnNull").getExpression().evaluate(context);
      assertThat(result, is(nullValue()));

      try {
        result = context.resolveExpressionRef("Ln0").getExpression().evaluate(context);
      } catch (ArithmeticException ae) {
        assertThat(ae.getMessage(), is("Results in negative infinity"));
      }

      try {
        result = context.resolveExpressionRef("LnNeg0").getExpression().evaluate(context);
      } catch (ArithmeticException ae) {
        assertThat(ae.getMessage(), is("Results in negative infinity"));
      }

      result = context.resolveExpressionRef("Ln1").getExpression().evaluate(context);
      assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(Math.log(1d)).setScale(8, RoundingMode.FLOOR)));

      result = context.resolveExpressionRef("LnNeg1").getExpression().evaluate(context);
      assertThat(result, is(nullValue()));

      result = context.resolveExpressionRef("Ln1000").getExpression().evaluate(context);
      assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(Math.log(1000)).setScale(8, RoundingMode.FLOOR)));

      result = context.resolveExpressionRef("Ln1000D").getExpression().evaluate(context);
      assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(Math.log(1000d)).setScale(8, RoundingMode.FLOOR)));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Max#evaluate(Context)}
     */
    @Test
    public void testMaximum() throws JAXBException {
      Context context = new Context(library);
      Object result = context.resolveExpressionRef("IntegerMaxValue").getExpression().evaluate(context);
      assertThat(result, is(Integer.MAX_VALUE));

      result = context.resolveExpressionRef("DecimalMaxValue").getExpression().evaluate(context);
      assertThat(result, is(Interval.maxValue(BigDecimal.class)));

      result = context.resolveExpressionRef("QuantityMaxValue").getExpression().evaluate(context);
      assertThat(result, is(Interval.maxValue(Quantity.class)));

      result = context.resolveExpressionRef("DateTimeMaxValue").getExpression().evaluate(context);
      assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(7), new int[] {9999, 12, 31, 23, 59, 59, 999})));

      result = context.resolveExpressionRef("TimeMaxValue").getExpression().evaluate(context);
      assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {23, 59, 59, 999})));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Min#evaluate(Context)}
     */
    @Test
    public void testMinimum() throws JAXBException {
      Context context = new Context(library);
      Object result = context.resolveExpressionRef("IntegerMinValue").getExpression().evaluate(context);
      assertThat(result, is(Integer.MIN_VALUE));

      result = context.resolveExpressionRef("DecimalMinValue").getExpression().evaluate(context);
      assertThat(result, is(Interval.minValue(BigDecimal.class)));

      result = context.resolveExpressionRef("QuantityMinValue").getExpression().evaluate(context);
      assertThat(result, is(Interval.minValue(Quantity.class)));

      result = context.resolveExpressionRef("DateTimeMinValue").getExpression().evaluate(context);
      assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(7), new int[] {0001, 1, 1, 0, 0, 0, 0})));

      result = context.resolveExpressionRef("TimeMinValue").getExpression().evaluate(context);
      assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {0, 0, 0, 0})));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Modulo#evaluate(Context)}
     */
    @Test
    public void testModulo() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("ModuloNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Modulo0By0").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Modulo4By2").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("Modulo4DBy2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0d)));

        result = context.resolveExpressionRef("Modulo10By3").getExpression().evaluate(context);
        assertThat(result, is((1)));

        result = context.resolveExpressionRef("Modulo10DBy3D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));

        result = context.resolveExpressionRef("Modulo10IBy3D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));

        result = context.resolveExpressionRef("ModuloDResult").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0.5)));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Multiply#evaluate(Context)}
     */
    @Test
    public void testMultiply() throws JAXBException {
        Context context = new Context(library);
        Object result = context.resolveExpressionRef("MultiplyNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Multiply1By1").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("Multiply1DBy2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(2.0)));

        result = context.resolveExpressionRef("Multiply1IBy2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(2.0)));

        // TODO: should return multiplied units i.e. cm2
        result = context.resolveExpressionRef("Multiply1CMBy2CM").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal(2.0)).withUnit("cm")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Negate#evaluate(Context)}
     */
    @Test
    public void testNegate() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("NegateNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Negate0").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("NegateNeg0").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("Negate1").getExpression().evaluate(context);
        assertThat(result, is(-1));

        result = context.resolveExpressionRef("NegateNeg1").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("Negate0D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-(0d))));

        result = context.resolveExpressionRef("NegateNeg0D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0d)));

        result = context.resolveExpressionRef("Negate1D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal((double) -1)));

        result = context.resolveExpressionRef("NegateNeg1D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("1.0")));

        result = context.resolveExpressionRef("Negate1CM").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal("-1.0")).withUnit("cm")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Predecessor#evaluate(Context)}
     */
    @Test
    public void testPredecessor() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("PredecessorNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("PredecessorOf0").getExpression().evaluate(context);
        assertThat(result, is(-1));

        result = context.resolveExpressionRef("PredecessorOf1").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("PredecessorOf1D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo((BigDecimal)Interval.predecessor(new BigDecimal(1.0))));

       result = context.resolveExpressionRef("PredecessorOf101D").getExpression().evaluate(context);
       assertThat(result, is(Interval.predecessor(new BigDecimal("1.01"))));

       result = context.resolveExpressionRef("PredecessorOfJan12000").getExpression().evaluate(context);
       assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(3), new int[] {1999, 12, 31})));

       result = context.resolveExpressionRef("PredecessorOfNoon").getExpression().evaluate(context);
       assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {11, 59, 59, 999})));

       try {
         result = context.resolveExpressionRef("PredecessorUnderflowDt").getExpression().evaluate(context);
       } catch (RuntimeException re) {
         assertThat(re.getMessage(), is("The result of the predecessor operation exceeds the minimum value allowed for type DateTime."));
       }

       try {
         result = context.resolveExpressionRef("PredecessorUnderflowT").getExpression().evaluate(context);
       } catch (RuntimeException re) {
         assertThat(re.getMessage(), is("The result of the predecessor operation exceeds the minimum value allowed for type Time."));
       }
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Power#evaluate(Context)}
     */
    @Test
    public void testPower() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("PowerNullToNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Power0To0").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("Power2To2").getExpression().evaluate(context);
        assertThat(result, is(4));

        result = context.resolveExpressionRef("PowerNeg2To2").getExpression().evaluate(context);
        assertThat(result, is(4));

       result = context.resolveExpressionRef("Power2ToNeg2").getExpression().evaluate(context);
       assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("0.25")));

        result = context.resolveExpressionRef("Power2DTo2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(4d)));

        result = context.resolveExpressionRef("PowerNeg2DTo2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(4d)));

        result = context.resolveExpressionRef("Power2DToNeg2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0.25)));

        result = context.resolveExpressionRef("Power2DTo2").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(4d)));

        result = context.resolveExpressionRef("Power2To2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(4d)));

        result = context.resolveExpressionRef("Power2To4").getExpression().evaluate(context);
        assertThat(result, is(16));

        result = context.resolveExpressionRef("Power2DTo4D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("16.0")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Round#evaluate(Context)}
     */
    @Test
    public void testRound() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("RoundNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Round1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));

        result = context.resolveExpressionRef("Round0D5").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(1.0)));

        result = context.resolveExpressionRef("Round0D4").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0.0)));

       result = context.resolveExpressionRef("Round3D14159").getExpression().evaluate(context);
       assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("3.14")));

        result = context.resolveExpressionRef("RoundNeg0D5").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0.0)));

        result = context.resolveExpressionRef("RoundNeg0D4").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(0.0)));

        result = context.resolveExpressionRef("RoundNeg0D6").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-1.0)));

        result = context.resolveExpressionRef("RoundNeg1D1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-1.0)));

        result = context.resolveExpressionRef("RoundNeg1D5").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-1.0)));

        result = context.resolveExpressionRef("RoundNeg1D6").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-2.0)));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Subtract#evaluate(Context)}
     */
    @Test
    public void testSubtract() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("SubtractNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Subtract1And1").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("Subtract1DAnd2D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-1.0)));

        result = context.resolveExpressionRef("Subtract1CMAnd2CM").getExpression().evaluate(context);
        assertThat(result, is(new Quantity().withValue(new BigDecimal(-1.0)).withUnit("cm")));

        result = context.resolveExpressionRef("Subtract2And11D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("0.9")));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Successor#evaluate(Context)}
     */
    @Test
    public void testSuccessor() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("SuccessorNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("SuccessorOf0").getExpression().evaluate(context);
        assertThat(result, is(1));

        result = context.resolveExpressionRef("SuccessorOf1").getExpression().evaluate(context);
        assertThat(result, is(2));

        result = context.resolveExpressionRef("SuccessorOf1D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo((BigDecimal)Interval.successor(new BigDecimal(1.0))));

       result = context.resolveExpressionRef("SuccessorOf101D").getExpression().evaluate(context);
       assertThat(result, is(Interval.successor(new BigDecimal("1.01"))));

       result = context.resolveExpressionRef("SuccessorOfJan12000").getExpression().evaluate(context);
       assertThat(((DateTime)result).getPartial(), is(new Partial(DateTime.getFields(3), new int[] {2000, 1, 2})));

       result = context.resolveExpressionRef("SuccessorOfNoon").getExpression().evaluate(context);
       assertThat(((Time)result).getPartial(), is(new Partial(Time.getFields(4), new int[] {12, 0, 0, 1})));

       try {
         result = context.resolveExpressionRef("SuccessorOverflowDt").getExpression().evaluate(context);
       } catch (RuntimeException re) {
         assertThat(re.getMessage(), is("The result of the successor operation exceeds the maximum value allowed for type DateTime."));
       }

       try {
         result = context.resolveExpressionRef("SuccessorOverflowT").getExpression().evaluate(context);
       } catch (RuntimeException re) {
         assertThat(re.getMessage(), is("The result of the successor operation exceeds the maximum value allowed for type Time."));
       }
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.Truncate#evaluate(Context)}
     */
    @Test
    public void testTruncate() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("TruncateNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("Truncate0").getExpression().evaluate(context);
        assertThat(result, is(0));

        result = context.resolveExpressionRef("Truncate0D0").getExpression().evaluate(context);
        assertThat(result, is((0)));

        result = context.resolveExpressionRef("Truncate0D1").getExpression().evaluate(context);
        assertThat(result, is((0)));

        result = context.resolveExpressionRef("Truncate1").getExpression().evaluate(context);
        assertThat(result, is((1)));

        result = context.resolveExpressionRef("Truncate1D0").getExpression().evaluate(context);
        assertThat(result, is((1)));

        result = context.resolveExpressionRef("Truncate1D1").getExpression().evaluate(context);
        assertThat(result, is((1)));

        result = context.resolveExpressionRef("Truncate1D9").getExpression().evaluate(context);
        assertThat(result, is((1)));

        result = context.resolveExpressionRef("TruncateNeg1").getExpression().evaluate(context);
        assertThat(result, is((-1)));

        result = context.resolveExpressionRef("TruncateNeg1D0").getExpression().evaluate(context);
        assertThat(result, is((-1)));

        result = context.resolveExpressionRef("TruncateNeg1D1").getExpression().evaluate(context);
        assertThat(result, is((-1)));

        result = context.resolveExpressionRef("TruncateNeg1D9").getExpression().evaluate(context);
        assertThat(result, is((-1)));
    }

    /**
     * {@link org.opencds.cqf.cql.elm.execution.TruncatedDivide#evaluate(Context)}
     */
    @Test
    public void testTruncatedDivide() throws JAXBException {
        Context context = new Context(library);
        Object result;

        result = context.resolveExpressionRef("TruncatedDivideNull").getExpression().evaluate(context);
        assertThat(result, is(nullValue()));

        result = context.resolveExpressionRef("TruncatedDivide2By1").getExpression().evaluate(context);
        assertThat(result, is(2));

        result = context.resolveExpressionRef("TruncatedDivide10By3").getExpression().evaluate(context);
        assertThat(result, is(3));

        result = context.resolveExpressionRef("TruncatedDivide10d1By3D1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(3.0)));

        result = context.resolveExpressionRef("TruncatedDivideNeg2ByNeg1").getExpression().evaluate(context);
        assertThat(result, is(2));

        result = context.resolveExpressionRef("TruncatedDivideNeg10ByNeg3").getExpression().evaluate(context);
        assertThat(result, is(3));

        result = context.resolveExpressionRef("TruncatedDivideNeg10d1ByNeg3D1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(3.0)));

        result = context.resolveExpressionRef("TruncatedDivideNeg2By1").getExpression().evaluate(context);
        assertThat(result, is(-2));

        result = context.resolveExpressionRef("TruncatedDivideNeg10By3").getExpression().evaluate(context);
        assertThat(result, is(-3));

        result = context.resolveExpressionRef("TruncatedDivideNeg10d1By3D1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-3.0)));

        result = context.resolveExpressionRef("TruncatedDivide2ByNeg1").getExpression().evaluate(context);
        assertThat(result, is((-2)));

        result = context.resolveExpressionRef("TruncatedDivide10ByNeg3").getExpression().evaluate(context);
        assertThat(result, is(-3));

        result = context.resolveExpressionRef("TruncatedDivide10d1ByNeg3D1").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal(-3.0)));

        result = context.resolveExpressionRef("TruncatedDivide10By5D").getExpression().evaluate(context);
        assertThat((BigDecimal)result, comparesEqualTo(new BigDecimal("2.0")));
    }
}
