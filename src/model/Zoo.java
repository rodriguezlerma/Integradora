package model;

public class Zoo {

    private String name;
    private String city;
    private String address;
    private String id;
    private String legalRepresentative;
    private double budget;

  

    public Zoo(String name, String city, String address, String id, String legalRepresentative, double budget){


        this.name = name;
        this.city = city;
        this.address = address;
        this.id = id;
        this.legalRepresentative = legalRepresentative;
        this.budget = budget;
    }

    public void setName(String name){

        this.name = name;

    }
    public void setCity(String city){

        this.city = city;

    }
    public void setAddress(String address){

        this.address = address;

    }
    public void setId(String id){

        this.id = id;

    }
    public void setLegalRepresentative(String legalRepresentative){

        this.legalRepresentative = legalRepresentative;

    }
    public void setBudget(double budget){

        this.budget = budget;
        
    }
    public String generalInformation(){

        return "\nNombre del zoologico: "+name
                +"\nCiudad: "+city
                +"\nDireccion: "+address
                +"\nCedula de representante legal: "+id
                +"\nNombre de representante legal: "+legalRepresentative
                +"\nPresupuesto del zoologico: "+budget;
    }
    
}
    