package com.example.notes.service;

import com.example.notes.repository.DescriptionRepo;
import com.example.notes.entity.Description;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionService {

    private final DescriptionRepo repository;

    public DescriptionService(DescriptionRepo repository) {
        this.repository = repository;
    }

    public List<Description> getDescription() {
        return repository.findAll();
    }

    public Description addDescription(Description d) {
        return repository.save(d);
    }

    public Description updateDescription(Description updated, Long id) {
        Description exist = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        exist.setText(updated.getText());
        return repository.save(exist);
    }

    public void deleteDescription(Long id) {
        repository.deleteById(id);
    }

    public Description getDescriptionById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Description not found"));
    }
}
