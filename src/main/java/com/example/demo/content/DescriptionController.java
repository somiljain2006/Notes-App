package com.example.demo.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/descriptions")
public class DescriptionController {

    private final DescriptionService descriptionService;

    @Autowired
    public DescriptionController(DescriptionService descriptionService) {
        this.descriptionService = descriptionService;
    }

    @GetMapping
    public List<Description> getDescription() {
        return descriptionService.getDescription();
    }

    @PostMapping("/create")
    public ResponseEntity<Description> addDescription(@RequestBody Description description) {
        Description saved = descriptionService.addDescription(description);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Description updateDescription(@RequestBody Description description,
                                         @PathVariable("id") Long id) {
        return descriptionService.updateDescription(description, id);
    }
}
