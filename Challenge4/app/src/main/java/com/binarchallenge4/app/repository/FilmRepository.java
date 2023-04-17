package com.binarchallenge4.app.repository;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.binarchallenge4.app.model.Films;

@Repository
public interface FilmRepository extends JpaRepository<Films, Long>{
    //List<Films> findByFilmName(String filmName, Pageable pageable);
}
