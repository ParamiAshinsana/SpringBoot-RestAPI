package org.example2.springdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example2.springdemo.dto.MovieDTO;
import org.example2.springdemo.service.MovieService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping(value = "/saveMovie")
    public MovieDTO saveCustomer(@RequestBody MovieDTO movieDTO){
        return movieService.saveMovie(movieDTO);
    }
}
