package com.binarchallenge4.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.binarchallenge4.app.model.Films;
import com.binarchallenge4.app.service.FilmService;


@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @PostMapping("/createFilm")
    public ResponseEntity<List<Films>> createFilm(@RequestBody List<Films> films) {
        List<Films> listFilm = filmService.createFilm(films);
        return ResponseEntity.ok().body(listFilm);
    }

    @GetMapping("/getAllFilm")
    public ResponseEntity<List<Films>> getAllFilm() {
        List<Films> films = filmService.getAllFilm();
        return ResponseEntity.ok().body(films);
    }

    @GetMapping("/getFilmById/{id}")
    public ResponseEntity<Films> getFilmById(@PathVariable Long id) {
        Films films = filmService.getFilmById(id);
        return ResponseEntity.ok().body(films);
    }
    
    


    

}
