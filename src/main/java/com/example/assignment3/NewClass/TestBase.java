package com.example.assignment3.NewClass;

public class TestBase implements Identifiable{

    private String name;
    private int id;

    public TestBase() {
    }

    public TestBase(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TestBase{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
