package com.example.demo;

import com.example.demo.content.Description;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Homepage {

	public static void main(String[] args) {
		SpringApplication.run(Homepage.class, args);
	}

    @GetMapping
    public List<Description> hello() {
        return List.of(
                new Description(1L, "My name is Somil")
        );
    }
}
