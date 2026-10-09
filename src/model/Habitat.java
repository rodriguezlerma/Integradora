package model;
import java.util.ArrayList;
public class Habitat {

    private static int nextId = 1;
    private String uniqueCode;
    private String name;
    private EnvironmentType environment; 
    private double temperature;
    private double area;
    private double budget;
    private int capacity;
    private String status;
    private Staff assignedStaff;
    private ArrayList<Animal> myAnimals;



    public Habitat(String name, EnvironmentType environment, double temperature, double area,
        double budget, int capacity, String status, Staff assignedStaff ){

            this.name = name;
            this.environment = environment;  //option
            this.temperature = temperature;
            this.area = area;
            this.budget = budget;
            this.capacity = capacity;
            this.status = status;
            this.assignedStaff = assignedStaff;
            uniqueCode = generateUniqueId();
            myAnimals = new ArrayList<Animal>();

                    }
    public String generateUniqueId() {
        String id = "HBT0" + nextId;
        nextId++;
        return id;
    }

    public String getUniqueCode() {
        return uniqueCode;
    }
    /**
     * Retrieves the type of environment in the habitat.
     *
     * @return The type of environment in the habitat.
     */

    public EnvironmentType getEnvironment(){

        return environment;
    }
                    
    
    /**
     * Retrieves the name of the habitat.
     *
     * @return The name of the habitat.
     */
    public String getName(){

        return name;
    }

    public double getTemperature(){

        return temperature;
    }
    public double getArea(){

        return area;
    }
    public double getBudget(){

        return budget;
    }
    public int getCapacity(){

        return capacity;
    }
    public String getStatus(){

        return status;
    }
    public Staff getAssignedStaff(){

        return assignedStaff;
    }
    public boolean addAnimals(Animal myAnimal){


        if (myAnimals.size() <= capacity){

            return myAnimals.add(myAnimal);


    }
    return false;
    }

    public String getAnimalList(){

        String animalList = "";

        for (int i = 0; i < myAnimals.size(); i++){

            animalList += myAnimals.get(i).getName() + "-"+myAnimals.get(i).getAnimalId()+"\n";
        }
        return animalList;

    }
    public int getAnimalCount() {
        return myAnimals.size();
    }

    public void setAssignedStaff(Staff assignedStaff){

        this.assignedStaff = assignedStaff;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEnvironment(EnvironmentType environment) {
        this.environment = environment;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Animal searchAnimal(String animalId){

        for (int i = 0; i < myAnimals.size(); i++) {

            if(myAnimals.get(i).getAnimalId().equalsIgnoreCase(animalId)){

                return myAnimals.get(i);
            }
            
        }
        return null;
    }
    /**
    * Removes an animal from the habitat.
    *
    * @param animal The animal to remove.
    * @return true if the animal was removed, false otherwise.
    */
    public boolean removeAnimal(Animal animal) {
    return myAnimals.remove(animal);
    
}
}