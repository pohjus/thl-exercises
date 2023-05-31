package datapackage;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.text.DecimalFormat;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(String name, double mass, double height) {
    public Person() {
        this(null, 0.0, 0.0);
    }
    public Person(String name) {
        this(name, 0.0, 0.0);
    }
    public double getBmi() {
        return mass / (height / 100.0 * height / 100.0);
    }
    public String getFormattedBmi() {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(getBmi());
    }
    @Override
    public String toString() {
        return name + ", bmi = " + getFormattedBmi();
    }
}