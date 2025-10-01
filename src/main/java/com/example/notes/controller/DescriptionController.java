
package com.example.notes.controller;

import com.example.notes.entity.Description;
import com.example.notes.service.DescriptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** This controller handles HTTP requests and provides CRUD operations. */
@RestController
@RequestMapping(path = "api/v1/descriptions")
public class DescriptionController {

  /**
  * Service layer component responsible for managing Description entities.
  * Provides business logic for creating, reading, updating, and deleting description objects.
  */
  private final DescriptionService descriptionService;

  /**
     * Dependency injection.
     * @param descriptionService is an instance.
  */
  @Autowired
  public DescriptionController(final DescriptionService descriptionService) {
    this.descriptionService = descriptionService;
  }

  /** GET request for all notes. */
  @GetMapping
  public List<Description> getDescription() {
    return descriptionService.getDescription();
  }

  /** POST request to create new notes. */
  @PostMapping("/create")
  public ResponseEntity<Description> addDescription(@RequestBody final Description description) {
    Description saved = descriptionService.addDescription(description);
    return new ResponseEntity<>(saved, HttpStatus.OK);
  }

  /** PUT request to update notes. */
  @PutMapping("/{id}")
  public Description updateDescription(@RequestBody final Description description, @PathVariable("id") final Long id) {
    return descriptionService.updateDescription(description, id);
  }

  /** DELETE request for notes. */
  @DeleteMapping("/{id}")
  public void deleteDescriptionById(@PathVariable("id") Long id) {
    descriptionService.deleteDescription(id);
  }

  /** GET request to show specific notes. */
  @GetMapping("/id/{id}")
  public ResponseEntity<Description> getDescriptionById(@PathVariable Long id) {
    Description desc = descriptionService.getDescriptionById(id);
    return new ResponseEntity<>(desc, HttpStatus.OK);
  }
}
