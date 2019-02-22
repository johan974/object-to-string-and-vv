package nl.deholtmans.kpi;

import java.util.ArrayList;
import java.util.List;

public class IndicatorDetailsNew {
    static final char FIELD_SEPERATOR = '$';
    private String  id;

    private String fieldsString;

    public IndicatorDetailsNew(String fieldsString) {
        this.fieldsString = fieldsString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFieldsString() {
        return fieldsString;
    }

    public void setFieldsString(String fieldsString) {
        this.fieldsString = fieldsString;
    }

    public List<IndicatorDetailsField> getFields() {
        return fields;
    }

    public void setFields(List<IndicatorDetailsField> fields) {
        this.fields = fields;
    }

    //@Transient
    List<IndicatorDetailsField> fields = new ArrayList<>();

    void convertFieldStringToFieldObjects() {
        fields = new ArrayList<>();
        if( fieldsString == null) {
            return;
        }
        String fieldParts[] = StringSplitter.getTokens( fieldsString, FIELD_SEPERATOR);
        int numberOfFields = fieldParts.length;
        if( numberOfFields < 1) {
            return ;
        }
        if( numberOfFields < 1 || numberOfFields % 3 != 0) {
            throw new RuntimeException( "Field string has an invalid number of tokens: " + fieldsString);
        }
        for( int i = 0; i < numberOfFields; i += 3) {
            fields.add( new IndicatorDetailsField( fieldParts[i], fieldParts[i+1], fieldParts[i+2]));
        }
    }
    void convertFieldObjectsToFieldString() {
        if( fields == null || fields.size() == 0) {
            fieldsString = "";
            return ;
        }
        StringBuilder sb = new StringBuilder();
        for( IndicatorDetailsField field : fields) {
            sb.append( nullBecomesEmptyString( field.getName()) + FIELD_SEPERATOR +
                       nullBecomesEmptyString( field.getValue()) + FIELD_SEPERATOR +
                       nullBecomesEmptyString( field.getUrl()) + FIELD_SEPERATOR);
        }
        fieldsString = sb.toString();
    }
    private String nullBecomesEmptyString( String value) {
        return value == null ? "" : value;
    }
}