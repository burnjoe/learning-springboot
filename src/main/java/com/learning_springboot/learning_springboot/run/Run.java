package com.learning_springboot.learning_springboot.run;

import java.time.LocalDateTime;

// This record or class is immutable
// It has prepared all the getters, equals, hashcode, toString
// But you won't be able to have the setters since it's an immutable class
public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
) {}
