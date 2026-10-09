package model;


public class Animal {

    private static int nextId = 1;

    private String animalId;
    private String name;
    private String species;
    private String sex;
    private int yearOfBirth;
    private double weight;
    private String diet;
    private EnvironmentType environment;
    private String countryOfOrigin;
    private String entryDate;
    private String healthStatus;
    private String lifeStage;
    private Habitat habitat;
    private boolean active;
    

    public Animal(String name, String species, String sex, int yearOfBirth, double weight, String diet,
            EnvironmentType environment, String countryOfOrigin, String entryDate,String healthStatus, 
            String lifeStage,Habitat habitat) {
        this.name = name;
        this.species = species;
        this.sex = sex;
        this.yearOfBirth = yearOfBirth;
        this.weight = weight;
        this.diet = diet;
        this.environment = environment;
        this.countryOfOrigin = countryOfOrigin;
        this.entryDate = entryDate;
        this.healthStatus = healthStatus;
        this.lifeStage = lifeStage;
        this.habitat = habitat;
        this.active = true;



        animalId = makeUniqueId();



    }
    public String makeUniqueId() {

        String id = "ANM0" + nextId;
        nextId++;
        return id;

    }
    public int getAge() {

        int currentYear = 2026;
        return currentYear - yearOfBirth;
    }
    public String getAnimalId() {
        return animalId;
    }
    
    public String getName() {
        return name;
    }
    public String getSpecies() {
        return species;
    }
    public String getSex() {
        return sex;
    }
    public double getWeight() {
        return weight;
    }
    public String getDiet() {
        return diet;
    }
    public EnvironmentType getEnvironment() {
        return environment;
    }
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }
    public String getEntryDate() {
        return entryDate;
    }
    public String getHealthStatus() {
        return healthStatus;
    }
    public String getLifeStage() {
        return lifeStage;
    }
    public boolean isActive() {
        return active;
    }
    public Habitat getHabitat(){

        return habitat;
    }
    public void setName(String name){

        this.name = name;
    }
    public void setWeight(double weight){

        this.weight = weight;
    }
    public void setDiet(String diet){

        this.diet = diet;
    }
    public void setLifeStage(String lifeStage){

        this.lifeStage = lifeStage;
    }
    public void setHealthStatus(String healthStatus){

        this.healthStatus = healthStatus;
    }
    public void setHabitat(Habitat habitat){

        this.habitat = habitat;
    }
}
