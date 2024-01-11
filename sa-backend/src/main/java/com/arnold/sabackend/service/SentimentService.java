package com.arnold.sabackend.service;

import com.arnold.sabackend.SentimentType;
import com.arnold.sabackend.entities.Client;
import com.arnold.sabackend.entities.Sentiment;
import com.arnold.sabackend.repositories.SentimentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentService {

    private SentimentRepository sentimentRepository;

    private ClientService clientService;

    public SentimentService(SentimentRepository sentimentRepository, ClientService clientService) {
        this.sentimentRepository = sentimentRepository;
        this.clientService= clientService;
    }

    public List<Sentiment> findAllSentiment(){
        return sentimentRepository.findAll();
    }

    public void create(Sentiment sentiment) {
        Client client= clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);

//        Analyse the sentiment using an external api prior to saving it
        if(sentiment.getTexte().toLowerCase().contains("good") || sentiment.getTexte().toLowerCase().contains("great")){
            sentiment.setType(SentimentType.POSITIVE);
        }else{
            sentiment.setType(SentimentType.NEGATIVE);
        }

        sentimentRepository.save(sentiment);
    }

    public void deleteById(int id) {
        sentimentRepository.deleteById(id);
    }
}
