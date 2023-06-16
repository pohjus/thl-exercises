package com.example.webfluxproject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

// Annotation to indicate that this class serves as a RESTful controller
@RestController
// Base URL path for all methods in this controller
@RequestMapping("/people")
public class PersonController {

    // Dependency on a service for converting CSV data to Person objects
    private final CsvToPersonService csvToPersonService;

    // Dependency Injection (DI) through constructor
    public PersonController(CsvToPersonService csvToPersonService) {
        this.csvToPersonService = csvToPersonService;
    }

    // Endpoint mapped to "/people/traditional"
    // This method, when invoked, uses the traditional synchronous approach to process a CSV file and returns a List of Person objects.
    @RequestMapping("/traditional")
    public List<Person> getPeopleTraditional() {
        return csvToPersonService.getPeopleTraditional("people-10000.csv");
    }

    // Endpoint mapped to "/people/webflux", it uses the HTTP GET method
    // This method uses Spring WebFlux to process a CSV file in a non-blocking, reactive way and returns a Flux of Person objects.
    // The response is produced as Server-Sent Events (SSE), a protocol that allows a server to push updates to a client.
    @GetMapping(value="webflux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> getPeople() {
        return csvToPersonService.getPeopleWebFlux("people-10000.csv");
    }
}