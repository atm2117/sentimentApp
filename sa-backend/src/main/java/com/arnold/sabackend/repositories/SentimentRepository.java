package com.arnold.sabackend.repositories;

import com.arnold.sabackend.entities.Sentiment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentimentRepository extends JpaRepository<Sentiment,Integer> {
}
