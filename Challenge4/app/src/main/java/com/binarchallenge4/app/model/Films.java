package com.binarchallenge4.app.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "film")
public class Films {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filmName;
    private Boolean isAvailable;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "filmId", referencedColumnName = "id")
    private List<Schedules> schedules;


    public Films(String filmName, Boolean isAvailable) {
        this.filmName = filmName;
        this.isAvailable = isAvailable;
    }

    public Films() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFilmName() {
        return filmName;
    }
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    
    
}
