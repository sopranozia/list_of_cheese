package org.launchcode.Hellospring.model;

public enum CheeseType {

    HARD("hard"),
    SOFT("soft"),
    FAKE("fake");

    private final String name;

    CheeseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
