package com.abdullah.Java6MovieAppMvc.controller;

import com.abdullah.Java6MovieAppMvc.repository.entity.Movie;
import com.abdullah.Java6MovieAppMvc.repository.entity.User;
import com.abdullah.Java6MovieAppMvc.service.GenreService;
import com.abdullah.Java6MovieAppMvc.service.MovieCommentService;
import com.abdullah.Java6MovieAppMvc.service.MovieService;
import com.abdullah.Java6MovieAppMvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final GenreService genreService;
    private final UserService userService;



    private final MovieCommentService movieCommentService;

    @GetMapping("/findall")
    public ModelAndView getMoviePage(Long userId){
        User user=new User();
        if (userId==null){
            user=new User();
        }else {
            user=userService.findById(userId).get();
        }
        List<Movie> movieList=movieService.findAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("movies",movieList);
        modelAndView.addObject("genreservice",genreService);
        //modelAndView.addObject("genres",genreService.findAll());//buda diger yolu
        modelAndView.addObject("user",user);
        modelAndView.setViewName("movies");
        return modelAndView;
    }

    @GetMapping("/findbyid/{id}")
    public ModelAndView getMovieById(@PathVariable Long id,@RequestParam(required = false) Long userId){
        ModelAndView modelAndView=new ModelAndView();
        User user;
        if (userId==null){
            modelAndView.addObject("user",null);

        }else {
            user=userService.findById(userId).get();
            modelAndView.addObject("user",user);
        }
        Optional<Movie> movie=movieService.findById(id);
        modelAndView.addObject("movie",movie.get());
        modelAndView.addObject("genreservice",genreService);
        modelAndView.addObject("commentservice",movieCommentService);
        modelAndView.addObject("userservice",userService);
        modelAndView.setViewName("moviesDetail");
        return modelAndView;
    }

}
