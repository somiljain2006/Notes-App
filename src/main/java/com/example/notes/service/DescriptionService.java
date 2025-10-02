
package com.example.notes.service;

import com.example.notes.entity.Description;
import com.example.notes.repository.DescriptionRepo;
import com.example.notes.service.interfaces.DescriptionServiceInterface;
import java.util.List;
import org.springframework.stereotype.Service;

/** Service-layer component that contains business logic. */
@Service
public class DescriptionService implements DescriptionServiceInterface {

  /** Repository for performing CRUD operations. */
  private final DescriptionRepo repository;

  /** Repository to be used for database operation. */
  public DescriptionService(final DescriptionRepo repository) {
    this.repository = repository;
  }

  /** Getting all the notes. */
  @Override
  public List<Description> getDescription() {
    return repository.findAll();
  }

  /** Adding the description. */
  @Override
  public Description addDescription(final Description d) {
    return repository.save(d);
  }

  /** Updating the description. */
  @Override
  public Description updateDescription(
          final Description updated, final Long id) {
    Description exist = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
    exist.setText(updated.getText());
    return repository.save(exist);
  }

  /** Deleting the note. */
  @Override
  public void deleteDescription(final Long id) {
    repository.deleteById(id);
  }

  /** Getting a single note's description. */
  @Override
  public Description getDescriptionById(
          final Long id) {
    return repository.findById(id)
           .orElseThrow(() -> new RuntimeException("Description not found"));
  }
}
