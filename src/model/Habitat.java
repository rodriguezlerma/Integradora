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

    public EnvironmentType environment(){

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


}