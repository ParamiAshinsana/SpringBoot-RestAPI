package org.example2.springdemo.mapping;

import lombok.RequiredArgsConstructor;
import org.example2.springdemo.dto.MovieDTO;
import org.example2.springdemo.entity.MovieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieMapping {
    private final ModelMapper mapper;

    public MovieDTO toMovieDTO(MovieEntity movieEntity) {
        return  mapper.map(movieEntity, MovieDTO.class);
    }
    public MovieEntity toMovie(MovieDTO movieDTO) {
        return  mapper.map(movieDTO, MovieEntity.class);
    }
    public List<MovieDTO> toMovieDTOList(List<MovieEntity> movieEntities) {
        return mapper.map(movieEntities, List.class);
    }

}
