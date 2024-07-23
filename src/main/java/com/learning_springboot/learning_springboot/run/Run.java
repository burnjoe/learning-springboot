package com.learning_springboot.learning_springboot.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

// This record or class is immutable
// It has prepared all the getters, equals, hashcode, toString
// But you won't be able to have the setters since it's an immutable class
public record Run(
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles,
        Location location
) {}
