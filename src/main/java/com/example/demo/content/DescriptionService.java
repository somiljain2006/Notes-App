package com.example.demo.content;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionService {

    public List<Description> getDescription() {
        return List.of(
                new Description(1L, "My name is Somil")
        ); 
    }
}
