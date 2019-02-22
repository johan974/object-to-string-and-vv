package nl.deholtmans.kpi;

public class StringSplitter {
    public static String[] getTokens( String input, char seperator) {
        if( input == null) {
            return new String[0];
        }
        int count = 0;
        for( char c : input.toCharArray()) {
            if( c == seperator) {
                count++;
            }
        }
        String[] output = new String[count];
        int stringIndex = 0;
        int stringStart = 0;
        int stringEnd = 0;
        for( char c : input.toCharArray()) {
            if( c == seperator) {
                output[stringIndex++] = input.substring( stringStart, stringEnd);
                stringStart = stringEnd + 1;
            }
            stringEnd++;
        }
        return output;
    }
}
