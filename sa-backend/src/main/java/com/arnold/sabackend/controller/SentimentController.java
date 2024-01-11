package com.arnold.sabackend.controller;


import com.arnold.sabackend.entities.Sentiment;
import com.arnold.sabackend.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="sentiment")
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Sentiment> getAllSentiment(){
        return sentimentService.findAllSentiment();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value= HttpStatus.CREATED)
    public void create(@RequestBody Sentiment sentiment){
        sentimentService.create(sentiment);
    }

    @DeleteMapping(path="{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteById(@PathVariable int id){
        sentimentService.deleteById(id);
    }
}
