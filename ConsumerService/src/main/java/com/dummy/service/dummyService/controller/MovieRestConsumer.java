package com.dummy.service.dummyService.controller;


import com.dummy.service.dummyService.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@FeignClient("movie-service/movie")
public interface MovieRestConsumer {
    @PostMapping(value = "/saveMovie" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAMovie(@RequestBody Movie movie);

    @GetMapping("/getMovies")
    public List<Movie> GatMovie();

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") ObjectId id);

    @PostMapping(value = "/updateMovie" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateMovie(@RequestBody Movie movie);
}
