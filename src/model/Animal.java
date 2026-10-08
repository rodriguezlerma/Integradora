package model;
import java.util.ArrayList;

public class Animal {

    private static int nextId = 1;

    private String animalId;
    private String name;
    private String species;
    private String gender;
    private int yearOfBirth;
    private double weight;
    private String diet;
    private String environment;
    private String healthStatus;
    

    public Animal(String name, String species, String gender, int yearOfBirth, double weight, String diet,
            String environment, String healthStatus) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
        this.diet = diet;
        this.environment = environment;
        this.healthStatus = healthStatus;
        animalId = makeUniqueId();



    }
    public String makeUniqueId() {

        String id = "ANM0" + nextId;
        nextId++;
        return id;

    }
    public int calculateAge() {

        int currentYear = 2026;
        return currentYear - yearOfBirth;
    }
    public String getAnimalId() {
        return animalId;
    }
    
    public String getName() {
        return name;
    }
}
