package com.binarchallenge4.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binarchallenge4.app.model.Films;
import com.binarchallenge4.app.repository.FilmRepository;

@Service
public class FilmService {
    
    @Autowired
    FilmRepository filmRepository;

    public List<Films> createFilm(List<Films> films) {
        return filmRepository.saveAll(films);
    }

    public List<Films> getAllFilm() {
        return filmRepository.findAll();
    }

    public Films getFilmById(Long id){
        return filmRepository.findById(id).orElseThrow(() -> new RuntimeException("Film not found"));
    }

    


    
}
