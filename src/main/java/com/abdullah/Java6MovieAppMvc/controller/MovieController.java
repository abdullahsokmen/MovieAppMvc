package com.abdullah.Java6MovieAppMvc.controller;

import com.abdullah.Java6MovieAppMvc.repository.entity.Movie;
import com.abdullah.Java6MovieAppMvc.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/findall")
    public ModelAndView getMoviePage(){
        List<Movie> movieList=movieService.findAll();
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("movies",movieList);
        modelAndView.setViewName("movies");
        return modelAndView;
    }

}
