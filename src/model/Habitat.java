package model;
import java.util.ArrayList;
public class Habitat {

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
            
            myAnimals = new ArrayList<Animal>();

                    }

        public EnvironmentType environment(){

            return environment;
        }
                    
    

    public String getName(){

        return name;
    }
    public boolean addAnimals(Animal myAnimal){


        if (myAnimals.size() <= capacity){

            return myAnimals.add(myAnimal);


    }
    return false;
    }


}