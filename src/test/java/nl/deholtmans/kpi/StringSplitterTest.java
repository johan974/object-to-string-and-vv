package nl.deholtmans.kpi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringSplitterTest {

    @Test
    public void testEmpty() {
        String input = null;
        assertEquals( 0, StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR).length);
    }

    @Test
    public void testAllNull() {
        String input = "" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testFirstNotNull() {
        String input = "first" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "first", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testMiddleNotNull() {
        String input = "" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "", output[0]);
        assertEquals( "middle", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testLastNotNull() {
        String input = "" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "last", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testAllEmpty() {
        String input = "" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testFirstNotEmpty() {
        String input = "first" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "first", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testMiddleNotEmpty() {
        String input = "" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "", output[0]);
        assertEquals( "middle", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testLastNotEmpty() {
        String input = "" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "last", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testFirstNullMiddleFilledNull() {
        String input = "any" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "any", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testAllNotNull() {
        String input = "first" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle" + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "first", output[0]);
        assertEquals( "middle", output[1]);
        assertEquals( "last", output[2]);
        assertEquals( 3, output.length);
    }

    @Test
    public void testThrice() {
        String input = "first" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        input = input + input + input;
        String[] output = StringSplitter.getTokens( input, IndicatorDetailsNew.FIELD_SEPERATOR);
        assertEquals( "first", output[0]);
        assertEquals( "", output[1]);
        assertEquals( "last", output[2]);
        assertEquals( "first", output[3]);
        assertEquals( "", output[4]);
        assertEquals( "last", output[5]);
        assertEquals( "first", output[6]);
        assertEquals( "", output[7]);
        assertEquals( "last", output[8]);
        assertEquals( 9, output.length);
    }
}
