package com.example.demo.content;

import org.springframework.stereotype.Component;
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
}
