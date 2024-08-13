package org.example2.springdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example2.springdemo.dto.MovieDTO;
import org.example2.springdemo.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping(value = "/saveMovie")
    public MovieDTO saveMovie(@RequestBody MovieDTO movieDTO){
        return movieService.saveMovie(movieDTO);
    }

    @PutMapping(value = "/updateMovie/{id}")
    public void updateMovie(@RequestBody MovieDTO movieDTO, @PathVariable ("id") String id){
        System.out.println("1");
        movieService.updateMovie(id,movieDTO);
        System.out.println("2");
        System.out.println("Movie Updated!");
        System.out.println("3");
    }
    @GetMapping(value = "/getAllMovies")
    List<MovieDTO> getAllMovie(){
        return movieService.getAllMovies();
    }
    @GetMapping("/getSelectedMovie/{id}")
    ResponseEntity<MovieDTO> getSelectedMovies(@PathVariable ("id") String id){
        MovieDTO selectedMovie = movieService.getSelectedMovie(id);
        return selectedMovie != null ? ResponseEntity.ok(selectedMovie) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
