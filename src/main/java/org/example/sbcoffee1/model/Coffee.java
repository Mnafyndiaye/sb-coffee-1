package org.example.sbcoffee1.model;

import java.util.UUID;

public class Coffee {
    private String id;
    private String name;

    // Constructeur sans arguments
    public Coffee() {
    }

    // Constructeur avec tous les champs
    public Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructeur avec uniquement le nom, l'id sera généré
    public Coffee(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
