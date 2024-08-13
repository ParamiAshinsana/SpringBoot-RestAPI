package org.example2.springdemo.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example2.springdemo.dto.MovieDTO;
import org.example2.springdemo.entity.MovieEntity;
import org.example2.springdemo.exception.NotFoundException;
import org.example2.springdemo.mapping.MovieMapping;
import org.example2.springdemo.repository.MovieRepository;
import org.example2.springdemo.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieServiceIMPL implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieMapping movieMapping;

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = movieMapping.toMovie(movieDTO);

        movieEntity = movieRepository.save(movieEntity);
        return movieMapping.toMovieDTO(movieEntity);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieMapping.toMovieDTOList(movieRepository.findAll());
    }

    @Override
    public MovieDTO getSelectedMovie(String id) {
        return null;
    }

    @Override
    public void deleteMovie(String id) {

    }

    @Override
    public void updateMovie(String id, MovieDTO movieDTO) {
        System.out.println("4");
        Optional<MovieEntity> tmpMovie = movieRepository.findById(id);
        System.out.println("5");
        if(!tmpMovie.isPresent()) throw new NotFoundException("Movie not found");
        System.out.println("6");
        tmpMovie.get().setMovieTitle(movieDTO.getMovieTitle());
        System.out.println("7");
        tmpMovie.get().setDirector(movieDTO.getDirector());
        System.out.println("8");
    }
}
