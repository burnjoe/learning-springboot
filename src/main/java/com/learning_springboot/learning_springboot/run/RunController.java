package com.learning_springboot.learning_springboot.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// This annotation allows to prepend the endpoint or uri in the specific mapping annotation
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // This will then use the prepended uri "/api/runs"
    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    // @PathVariable extracts the id from the placeholder {id} in URI
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        return runRepository.findById(id);
    }

}
