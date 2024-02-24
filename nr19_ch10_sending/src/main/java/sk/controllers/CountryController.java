package sk.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sk.model.Country;

@RestController
public class CountryController {
    
    //example for sending objects as a response body
    @GetMapping("/france")
    public Country france() {
        Country c = Country.of("France", 67);
        return c;
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country c1 = Country.of("France", 67);
        Country c2 = Country.of("Spain", 47);

        return List.of(c1,c2);
    }

    //example for adding cutom headers and setting a response status
    @GetMapping("/spain")
    public ResponseEntity<Country> spain() {
        Country c = Country.of("Spain", 47);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent", "Europe")
            .header("capital", "Madrid")
            .body(c);
    }
}
