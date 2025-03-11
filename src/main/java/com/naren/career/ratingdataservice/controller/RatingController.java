package com.naren.career.ratingdataservice.controller;

import com.naren.career.ratingdataservice.resource.Rating;
import com.naren.career.ratingdataservice.resource.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating("Transformers desc", 5);
    }

    @GetMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        List<Rating> ratingList = new ArrayList<>();
        IntStream.range(1,100).forEach(i-> ratingList.add(new Rating("10"+i,  getRating())));
        List<Rating> ratings = Arrays.asList(new Rating("100", 5),
                new Rating("101", 6));
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratingList);

        return userRating;
    }

    private Integer getRating(){
        List<Integer> ratingList = new ArrayList<>();
        IntStream.range(5,10).forEach(ratingList::add);

        Random random = new Random();
        int randomIndex = random.nextInt(ratingList.size());
        return ratingList.get(randomIndex);

    }





}
