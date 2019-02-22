package nl.deholtmans.kpi;

public class IndicatorDetailsField {
    private String  name;
    private String  value;
    private String  url;

    public IndicatorDetailsField() {
    }

    public IndicatorDetailsField(String name, String value, String url) {
        this.name = name;
        this.value = value;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "IndicatorDetailsField{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
