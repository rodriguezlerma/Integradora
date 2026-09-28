package model;

public class Habitat {

    private String name;
    private String environment;
    private double temperature;
    private double area;
    private double budget;
    private int capacity;
    private String status;

    private Animal[] myAnimals;



    public Habitat(String name, String environment, double temperature, double area,
        double budget, int capacity, String status){

            this.name = name;
            this.environment = environment;
            this.temperature = temperature;
            this.area = area;
            this.budget = budget;
            this.capacity = capacity;
            this.status = status;
                
                    }
                    
    

    public String getName(){

        return name;
    }
    }

