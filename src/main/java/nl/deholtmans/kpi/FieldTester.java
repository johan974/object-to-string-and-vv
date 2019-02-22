package nl.deholtmans.kpi;

import java.util.ArrayList;
import java.util.List;

public class FieldTester {
    public static void main(String[] args) {
        List<IndicatorDetailsField> fields = new ArrayList<>();
        // Empty fields
        IndicatorDetailsNew detailsnew = new IndicatorDetailsNew( "detail1");
        detailsnew.setFields( fields);
        detailsnew.convertFieldObjectsToFieldString();
        if( ! detailsnew.getFieldsString().equals( "")) {
            System.out.println("ERROR: empty fields gives no empty string");
        }

        // Fields object with null items
        fields.add( new IndicatorDetailsField( "name1", null, null));
        detailsnew.convertFieldObjectsToFieldString();
        if( ! detailsnew.getFieldsString().equals( "name1$$$")) {
            System.out.println("ERROR: single fields with 2 x null gives invalid string");
        }
        detailsnew.convertFieldStringToFieldObjects();
        fields = detailsnew.getFields();
        if( ! fields.get( 0).getName().equals( "name1")) {
            System.out.println( "ERROR: field.name should be name1");
        }
        if( ! fields.get( 0).getValue().equals( "")) {
            System.out.println( "ERROR: field.value should be empty");
        }
        if( ! fields.get( 0).getUrl().equals( "")) {
            System.out.println( "ERROR: field.url should be empty");
        }
    }
}
