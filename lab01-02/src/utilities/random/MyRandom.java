
package random;
import java.util.*;
import datapackage.Person;


public interface MyRandom {
    public String getRandomWord(String... args);

    public static MyRandom getInstance() {
        ServiceLoader<MyRandom> services = ServiceLoader.load(MyRandom.class);
        return services.findFirst().get();
    }

    // creates a list of person objects. Each object has a name given from the
    // argument. List is shuffled and returned
    public default List<Person> getRandomListOfPeopleWithNames(String... args) {
        List<Person> people = new ArrayList<>(List.of(args).stream()
                .map(Person::new)
                .toList());
        Collections.shuffle(people);
        return people;
    }
}
