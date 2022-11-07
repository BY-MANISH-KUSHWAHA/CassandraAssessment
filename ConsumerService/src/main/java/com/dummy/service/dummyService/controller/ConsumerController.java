package com.dummy.service.dummyService.controller;


import com.dummy.service.dummyService.model.Movie;
import com.dummy.service.dummyService.model.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import com.jayway.jsonpath.JsonPath;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {
//    @Autowired
    UserRestConsumer restConsumer;

//    @Autowired
    AuthRestConsumer authRestConsumer;

//    @Autowired
    MovieRestConsumer movieRestConsumer;

    @Autowired
    public ConsumerController(UserRestConsumer restConsumer, AuthRestConsumer authRestConsumer, MovieRestConsumer movieRestConsumer) {
        this.restConsumer = restConsumer;
        this.authRestConsumer = authRestConsumer;
        this.movieRestConsumer = movieRestConsumer;
    }

    @GetMapping("/get-users")
    List<User> getUsers(){
        System.out.println(restConsumer.getClass().getSimpleName());
        return restConsumer.getAll();
    }

    @PostMapping(value = "/saveUser" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAUser(@RequestBody User user){
        // token = AuthConsumer.generateToken()
        // return cutsom method
        return restConsumer.savingAUser(user);
    }

    @PostMapping(value = "/login" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String loginAUser(@RequestBody User user){
        String response = restConsumer.loginAUser(user);
        System.out.println(response);
        boolean status = JsonPath.read(response, "$.status");
        if(status==false){
            return response;
        }
        return response.substring(0,response.length()-1)+
                ",\"token\":"+createToken(user.getId())+"}";
    }

    @GetMapping(value="/getToken/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String createToken(@PathVariable("id") int id){
        return authRestConsumer.createToken(id);
    }



    @PostMapping(value = "/saveMovie" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String savingAMovie(@RequestBody Movie movie){
        return movieRestConsumer.savingAMovie(movie);
    }

    @GetMapping("/getMovies")
    public List<Movie> GatMovie(){
        return  movieRestConsumer.GatMovie();
    }

    @DeleteMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") ObjectId id) {
        return  movieRestConsumer.deleteMovie(id);
    }

    @PostMapping(value = "/updateMovie" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateMovie(@RequestBody Movie movie){
        return movieRestConsumer.updateMovie(movie);
    }


}
