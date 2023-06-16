package com.example.webfluxproject;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvToPersonService {

    // Method that returns a list of Person objects, takes a file path as an argument
    public List<Person> getPeopleTraditional(String filePath) {
        // Initialize an empty list of Person objects
        List<Person> people = new ArrayList<>();

        // Try-with-resources block to automatically close the BufferedReader after use
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line of the file until there are none left
            while ((line = reader.readLine()) != null) {
                // Pause the execution of the current thread for 10 milliseconds
                // This is usually not required and could slow down the processing significantly
                Thread.sleep(10);

                // Split the line by comma, assuming the file is in CSV format
                String[] fields = line.split(",");

                // Create a new Person object from the split data
                // Assuming the Person constructor takes these arguments in this order
                // Indexing assumes the file has these fields in the same order
                Person person = new Person(
                        Integer.parseInt(fields[0]), // Parse the first field as an integer
                        fields[1], // second field as a string
                        fields[2], // third field as a string
                        fields[3], // fourth field as a string
                        fields[4], // fifth field as a string
                        fields[5], // sixth field as a string
                        fields[6], // seventh field as a string
                        LocalDate.parse(fields[7]), // Parse the eighth field as a LocalDate
                        fields[8] // ninth field as a string
                );

                // Add the newly created Person object to the list of people
                people.add(person);
            }
            // Catch block to handle exceptions related to file I/O and thread interruptions
        } catch (IOException | InterruptedException e) {
            // Wrap any caught exceptions in a RuntimeException with a custom message
            throw new RuntimeException("Error reading CSV file", e);
        }

        // Return the list of Person objects
        return people;
    }

    // The method getPeopleWebFlux is intended to read data from a CSV file
    // located at the provided filePath and convert each line into a Person
    // object. It returns a Flux<Person> which is a stream of Person objects
    // that can be consumed in a reactive way.
    public Flux<Person> getPeopleWebFlux(String filePath) {
        try {
            // A BufferedReader is created to read from the CSV file located at filePath.
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // Flux.generate is used to create a Flux<Person> from the file data.
            // The Consumer function provided to Flux.generate is called each time
            // a subscriber to the Flux requests more items.
            return Flux.<Person>generate(sink -> {
                try {
                    // A line is read from the file.
                    String line = reader.readLine();

                    // If the line is null, it means we've reached the end of the file,
                    // so we signal that the Flux is complete.
                    if (line == null) {
                        sink.complete();
                    } else {
                        // If a line was read, it is split into fields by comma,
                        // the delimiter in the CSV file.
                        String[] fields = line.split(",");

                        // A new Person object is created from the fields and emitted
                        // to subscribers by calling sink.next.
                        Person person = new Person(
                                Integer.parseInt(fields[0]),
                                fields[1],
                                fields[2],
                                fields[3],
                                fields[4],
                                fields[5],
                                fields[6],
                                LocalDate.parse(fields[7]),
                                fields[8]
                        );
                        sink.next(person);
                    }
                } catch (IOException e) {
                    // If an IOException occurs while reading a line from the file,
                    // it is signaled to subscribers by calling sink.error.
                    sink.error(e);
                }
            }).delayElements(Duration.ofSeconds(1));
        } catch (IOException e) {
            // If an IOException occurs while opening the BufferedReader,
            // a Flux that immediately signals this error is returned.
            return Flux.error(e);
        }
    }
}