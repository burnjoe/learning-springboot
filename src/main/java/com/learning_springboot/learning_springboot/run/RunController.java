package com.learning_springboot.learning_springboot.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
// This annotation allows to prepend the endpoint or uri in the specific mapping annotation
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // GET ALL
    // This will then use the prepended uri "/api/runs"
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    // GET ONE
    // @PathVariable extracts the id from the placeholder {id} in URI
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
            // Uses created exception
            throw new RunNotFoundException();
        }
        return run.get();
    }

    // POST
    // @RequestBody annotation helps bind http request body to a Run object
    // @ResponseStatus here returns Status Code: 201 when succeed in creation of run
    // @Valid validates the constraints set to the specific fields of run defined in repository
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    // PUT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
