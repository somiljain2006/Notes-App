
package com.example.notes.controller;

import com.example.notes.dto.DescriptionDTO;
import com.example.notes.entity.Description;
import com.example.notes.mapper.DescriptionMapper;
import java.util.List;
import java.util.stream.Collectors;
import com.example.notes.service.interfaces.DescriptionServiceInterface;
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
  * Provides business logic for creating, reading, updating, and deleting
  * description objects.
  */
  private final DescriptionServiceInterface descriptionService;

  /**
     * Dependency injection.
  */
  @Autowired
  public DescriptionController(final DescriptionServiceInterface descriptionService) {
    this.descriptionService = descriptionService;
  }

  /** GET request for all notes. */
  @GetMapping
  public List<DescriptionDTO> getDescription() {
    return descriptionService.getDescription()
      .stream()
      .map(DescriptionMapper::toDTO)
      .collect(Collectors.toList());
  }

  /** POST request to create new notes. */
  @PostMapping("/create")
  public ResponseEntity<DescriptionDTO> addDescription(
      @RequestBody final DescriptionDTO descriptionDTO) {
    Description toSave = DescriptionMapper.toEntity(descriptionDTO);
    Description saved = descriptionService.addDescription(toSave);
    DescriptionDTO savedDto = DescriptionMapper.toDTO(saved);
    return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
  }

  /** PUT request to update notes. */
  @PutMapping("/{id}")
  public ResponseEntity<DescriptionDTO> updateDescription(
      @RequestBody final DescriptionDTO descriptionDTO,
      @PathVariable("id") final Long id) {
    Description toUpdate = DescriptionMapper.toEntity(descriptionDTO);
    Description updated = descriptionService.updateDescription(toUpdate, id);
    DescriptionDTO updatedDto = DescriptionMapper.toDTO(updated);
    return ResponseEntity.ok(updatedDto);
  }

  /** DELETE request for notes. */
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDescriptionById(@PathVariable("id") final Long id) {
    descriptionService.deleteDescription(id);
    return ResponseEntity.noContent().build();
  }

  /** GET request to show specific notes. */
  @GetMapping("/id/{id}")
  public ResponseEntity<DescriptionDTO> getDescriptionById(
      @PathVariable final Long id) {
    Description desc = descriptionService.getDescriptionById(id);
    DescriptionDTO dto = DescriptionMapper.toDTO(desc);
    return new ResponseEntity<>(dto, HttpStatus.OK);
  }
}
