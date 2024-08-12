package org.example2.springdemo.controller;

import lombok.RequiredArgsConstructor;
import org.example2.springdemo.service.MovieService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
}
