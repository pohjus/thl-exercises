package datapackage;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(String name, double mass, double height) {
    // Jackson requires default constructor?
    public Person() {
        this(null, 0.0, 0.0);
    }
    public Person(String name) {
        this(name, 0.0, 0.0);
    }
    public double getBmi() {
        return mass / (height / 100.0 * height / 100.0);
    }
    @Override
    public String toString() {
        return name + ", bmi = " + getBmi();
    }
}