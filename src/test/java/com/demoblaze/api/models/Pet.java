package com.demoblaze.api.models;

public class Pet {
    public int id;
    public String name;
    public Category category;
    public String status;

    public Pet(int id, String name, Category category, String status) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.status = status;
    }

    public static class Category {
        public int id;
        public String name;

        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
