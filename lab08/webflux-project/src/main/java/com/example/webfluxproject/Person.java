package com.example.webfluxproject;

import java.time.LocalDate;

// Define a new record named 'Person'
// Records are a special kind of class introduced in Java 14 as a preview feature and finalized in Java 16
// They are an immutable data carrier class, perfect for encapsulating grouped data without requiring verbose syntax

public record Person(
        int index,
        String userId,
        String firstName,
        String lastName,
        String sex,
        String email,
        String phone,
        LocalDate dateOfBirth,
        String jobTitle
){}