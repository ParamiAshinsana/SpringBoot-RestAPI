package org.example2.springdemo.service;

import org.example2.springdemo.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO saveMovie(MovieDTO movieDTO);
    List<MovieDTO> getAllMovies();
    MovieDTO getSelectedMovie(String id);
    void deleteMovie(String id);
    void updateMovie(String id, MovieDTO movieDTO);
}
