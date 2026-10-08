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
    private EnvironmentType environment;
    private String countryOfOrigin;
    private String entryDate;
    private String healthStatus;
    private Habitat habitat;
    private boolean active;
    

    public Animal(String name, String species, String gender, int yearOfBirth, double weight, String diet,
            EnvironmentType environment, String countryOfOrigin, String entryDate,String healthStatus, 
            Habitat habitat, boolean active) {
        this.name = name;
        this.species = species;
        this.gender = gender;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
        this.diet = diet;
        this.environment = environment;
        this.countryOfOrigin = countryOfOrigin;
        this.entryDate = entryDate;
        this.healthStatus = healthStatus;
        this.habitat = habitat;
        this.active = active;


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
