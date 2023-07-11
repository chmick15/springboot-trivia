package com.nicolas.trivia.entities;

public class Categoria {
    private String category;
    private String description;

    public Categoria(){}
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
