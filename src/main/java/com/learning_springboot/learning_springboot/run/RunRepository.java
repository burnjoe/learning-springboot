package com.learning_springboot.learning_springboot.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    // Get all records
    List<Run> findAll() {
        return runs;
    }

    // Get one record given id
    Optional<Run> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    // Create one record given request body
    void create(Run run) {
        runs.add(run);
    }

    // Update existing record given id
    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    // Delete existing record given id
    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    // @PostConstruct allows initialization of data
    @PostConstruct
    private void init() {
        runs.add(new Run(
           1,
           "Morning Run",
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1),
            3,
            Location.INDOOR
        ));
        runs.add(new Run(
           2,
           "Night Run",
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(1),
            1,
            Location.OUTDOOR
        ));
    }

}