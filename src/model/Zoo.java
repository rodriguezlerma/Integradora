package model;

public class Zoo {
    
    private String name;
    private String city;
    private String address;
    private String id;
    private String legalRepresentative;
    private double budget;

    private Habitat[] myHabitats;


    public Zoo(String name, String city, String address, String id, String legalRepresentative, double budget){


        this.name = name;
        this.city = city;
        this.address = address;
        this.id = id;
        this.legalRepresentative = legalRepresentative;
        this.budget = budget;

        this.myHabitats = new Habitat[33];
        veterinaryClinic();

    }

    private void veterinaryClinic(){
        

        new Habitat("Clinica veterinaria",calculateEnvironmentType(4), 27, 400, 40000000, 25, "activo");
            
        
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
    
    public boolean hasAvailableHabitat() {

        if (myHabitats != null) {

            for (int i = 0; i < myHabitats.length; i++) {
                if (myHabitats[i] == null) {
                    return true;
                }
            }
        }
        return false;
    
    }

    public boolean addHabitats(String name, int environment, double temperature, double area, double budget, int capacity, String status  ){

        if(hasAvailableHabitat()){

            for (int i = 0; i < myHabitats.length; i++) {

                if (myHabitats[i] == null){

                myHabitats[i] = new Habitat(name, calculateEnvironmentType(environment),temperature, area, budget, capacity, status);
            return true;
        }
    }
}return false;
}
    public String getHabitats(){

        String habitatsList = "";

        if(myHabitats != null){

            for (int i = 0; i < myHabitats.length; i++) {

                if(myHabitats[i] != null){

                    habitatsList +=  "\n" + myHabitats[i].getName();

                }    
                
            
        }
        if (habitatsList.equals("")){

            return "No hay animales en este habitat. ";
        }
    }
    
    return habitatsList;

    }
    public EnvironmentType calculateEnvironmentType (int environmentOpcion){

        //LAND,WATER,AVIARY,MEDICAL


        EnvironmentType[] values = EnvironmentType.values();

        return values[environmentOpcion - 1 ];
    }

    public String getEnvironmentTypeList(){

        String environmentList = "";

        EnvironmentType[] values = EnvironmentType.values();

        for (int index = 0; index < values.length; index++){


            environmentList += (index+1)+"."+values[index].getTypeName()+"\n";
        }

        return environmentList;
    }

}

