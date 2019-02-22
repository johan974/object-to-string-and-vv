package nl.deholtmans.kpi;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IndicatorDetailsNewTest {
    @Test
    public void testBasicFieldString() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR);
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(1, detailsNew.getFields().size());
    }

    @Test
    public void testNullFieldString() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew(null);
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(0, detailsNew.getFields().size());
    }

    @Test
    public void testEmptyFieldString() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("");
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(0, detailsNew.getFields().size());
    }

    @Test
    public void testFieldStringWith2Empty() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFieldsString("name" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR);
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(1, detailsNew.getFields().size());
        assertEquals("name", detailsNew.getFields().get(0).getName());
        assertEquals("", detailsNew.getFields().get(0).getValue());
        assertEquals("", detailsNew.getFields().get(0).getUrl());

    }

    @Test
    public void testFieldStringMiddleEmpty() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFieldsString("name" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR);
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(1, detailsNew.getFields().size());
        assertEquals("name", detailsNew.getFields().get(0).getName());
        assertEquals("", detailsNew.getFields().get(0).getValue());
        assertEquals("last", detailsNew.getFields().get(0).getUrl());

    }

    @Test
    public void testFieldStringMiddleEmpty2Times() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        String input = "name" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        input = input + input;
        detailsNew.setFieldsString(input);
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(2, detailsNew.getFields().size());
        assertEquals("name", detailsNew.getFields().get(0).getName());
        assertEquals("", detailsNew.getFields().get(0).getValue());
        assertEquals("last", detailsNew.getFields().get(0).getUrl());
        assertEquals("name", detailsNew.getFields().get(1).getName());
        assertEquals("", detailsNew.getFields().get(1).getValue());
        assertEquals("last", detailsNew.getFields().get(1).getUrl());

    }

    @Test
    public void testFieldStringMiddlePartIsEmpty() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        String input = "name" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        input = input + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR + input;
        detailsNew.setFieldsString(input);
        detailsNew.convertFieldStringToFieldObjects();
        assertEquals(3, detailsNew.getFields().size());
        assertEquals("name", detailsNew.getFields().get(0).getName());
        assertEquals("", detailsNew.getFields().get(0).getValue());
        assertEquals("last", detailsNew.getFields().get(0).getUrl());
        assertEquals("", detailsNew.getFields().get(1).getName());
        assertEquals("", detailsNew.getFields().get(1).getValue());
        assertEquals("", detailsNew.getFields().get(1).getUrl());
        assertEquals("name", detailsNew.getFields().get(2).getName());
        assertEquals("", detailsNew.getFields().get(2).getValue());
        assertEquals("last", detailsNew.getFields().get(2).getUrl());
    }

    @Test
    public void testNoFieldObjects() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFields(null);
        detailsNew.convertFieldObjectsToFieldString();
        assertEquals("", detailsNew.getFieldsString());
    }

    @Test
    public void testEMptyFieldObject() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFields(Arrays.asList(new IndicatorDetailsField("name", null, null)));
        detailsNew.convertFieldObjectsToFieldString();
        String output = "name" + IndicatorDetailsNew.FIELD_SEPERATOR + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR;
        assertEquals(output, detailsNew.getFieldsString());
    }

    @Test
    public void test1FieldObject() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFields(Arrays.asList(new IndicatorDetailsField("name", "middle", null)));
        detailsNew.convertFieldObjectsToFieldString();
        String output = "name" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle" + IndicatorDetailsNew.FIELD_SEPERATOR + "" + IndicatorDetailsNew.FIELD_SEPERATOR;
        assertEquals(output, detailsNew.getFieldsString());
    }

    @Test
    public void test1FieldFilledObject() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFields(Arrays.asList(new IndicatorDetailsField("name", "middle", "last")));
        detailsNew.convertFieldObjectsToFieldString();
        String output = "name" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle" + IndicatorDetailsNew.FIELD_SEPERATOR + "last" + IndicatorDetailsNew.FIELD_SEPERATOR;
        assertEquals(output, detailsNew.getFieldsString());
    }

    @Test
    public void test2FieldFilledObject() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFields(Arrays.asList(new IndicatorDetailsField("name1", "middle1", "last1"),
                new IndicatorDetailsField("name2", "middle2", "last2")));
        detailsNew.convertFieldObjectsToFieldString();
        String output = "name1" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle1" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "last1" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "name2" + IndicatorDetailsNew.FIELD_SEPERATOR + "middle2" + IndicatorDetailsNew.FIELD_SEPERATOR + "last2" + IndicatorDetailsNew.FIELD_SEPERATOR;
        assertEquals(output, detailsNew.getFieldsString());
    }

    @Test
    public void test3FieldPartlyFilledObject() {
        IndicatorDetailsNew detailsNew = new IndicatorDetailsNew("name");
        detailsNew.setFields(Arrays.asList(new IndicatorDetailsField("name1", null, "last1"),
                new IndicatorDetailsField("name2", "middle2", ""),
                new IndicatorDetailsField("name3", null, "")));
        detailsNew.convertFieldObjectsToFieldString();
        String output = "name1" + IndicatorDetailsNew.FIELD_SEPERATOR + "" +
                IndicatorDetailsNew.FIELD_SEPERATOR +
                "last1" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "name2" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "middle2" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "name3" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "" + IndicatorDetailsNew.FIELD_SEPERATOR +
                "" + IndicatorDetailsNew.FIELD_SEPERATOR;
        assertEquals(output, detailsNew.getFieldsString());
    }
}
