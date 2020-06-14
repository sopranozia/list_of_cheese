package org.launchcode.Hellospring.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {


    @NotNull
    @Size(min=3,max=15)
    private String name;
    @NotNull
    @Size(min=3, max=30)
    private String description;
    private int cheeseId;
    private static int nextId = 1;


    private CheeseType type;

    public Cheese(String name, String description) {
       this();
        this.name = name;
        this.description = description;
    }

    public Cheese(){

        cheeseId = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Cheese.nextId = nextId;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
