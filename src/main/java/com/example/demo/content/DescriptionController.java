package com.example.demo.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
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
}
