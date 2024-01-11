package com.arnold.sabackend.entities;

import com.arnold.sabackend.SentimentType;
import jakarta.persistence.*;

@Entity
@Table(name="SENTIMENT")
public class Sentiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String texte;
    private SentimentType type;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String texte, SentimentType type, Client client) {
        this.id = id;
        this.texte = texte;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public SentimentType getType() {
        return type;
    }

    public void setType(SentimentType type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Sentiment{" +
                "id=" + id +
                ", texte='" + texte + '\'' +
                ", type='" + type + '\'' +
                ", client=" + client +
                '}';
    }
}
