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
    private ArrayList<Staff> assignedStaff;
    private ArrayList<Animal> myAnimals;



    public Habitat(String name, EnvironmentType environment, double temperature, double area,
        double budget, int capacity, String status){

            this.name = name;
            this.environment = environment;  //option
            this.temperature = temperature;
            this.area = area;
            this.budget = budget;
            this.capacity = capacity;
            this.status = status;
            uniqueCode = generateUniqueId();
            assignedStaff = new ArrayList<Staff>();
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
    /**
     * Adds an animal to the habitat if there is available space.
     *
     * Preconditions:
     * - The `myAnimal` parameter must not be null.
     * - The 'myAnimals' list must be initialized.
     *
     * Postconditions:
     * - If the habitat is not full, the animal is added to the `myAnimals` list.
     *
     * @param myAnimal The animal to be added to the habitat.
     * @return true if the animal was successfully added, false if the habitat is
     *         full.
     */
  
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

    public boolean addAnimals(Animal myAnimal){


        if (myAnimals.size() <= capacity){

            return myAnimals.add(myAnimal);


    }
    return false;
    }

    public String getAnimalList(){

        String animalList = "";

        for (int i = 0; i < myAnimals.size(); i++){

            animalList += myAnimals.get(i).getName() + "\n";
        }
        return animalList;

    }

    public boolean addStaff(Staff staff) {

    if (staff == null) {
        return false;
    }

    if (assignedStaff.contains(staff)) {
        return false;
    }

    assignedStaff.add(staff);
    return true;
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
}