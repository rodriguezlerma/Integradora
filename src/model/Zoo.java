package model;
import java.util.ArrayList;

public class Zoo {
    
    public static int maxHabitats = 33;
    
    public static int capacityMax = 4; // Starting capacity for the veterinary clinic

    
    private String name;
    private String city;
    private String address;
    private String id;
    private String legalRepresentative;
    private double budget;
    private ArrayList<Staff> employees;
    private Habitat[] myHabitats;

  
    public Zoo(String name, String city, String address, String id, String legalRepresentative, double budget){


        this.name = name;
        this.city = city;
        this.address = address;
        this.id = id;
        this.legalRepresentative = legalRepresentative;
        this.budget = budget;
        
        employees = new ArrayList<>();

        
        myHabitats = new Habitat[maxHabitats];

        veterinaryClinic();

    }

    public int setPosition(double area){

        int position = 0;

        if(area > 0 && area <= 100){

            position = 1;

        }else if(area > 100 && area <= 200){

            position = 2;

        }else if(area > 200 && area <= 300){

            position = 3;

        }else if (area > 300 && area <= 400){

            position = 4;

    }
    return position;

}


    public Staff searchStaff(String codeStaff){

        for(int i = 0; i < employees.size(); i++){

            if(employees.get(i).getUniqueId().equalsIgnoreCase(codeStaff)){

                return employees.get(i);
            }
        }

        return null;

    }
    public String habitatCaracterisics(String codeHabitat){
        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null){

            return "Nombre: " + habitat.getName() + "\n" +
            "Codigo: " + habitat.getUniqueCode() + "\n" +
            "Entorno: " + habitat.getEnvironment() + "\n" +
            "Temperatura: " + habitat.getTemperature() + "\n" +
            "Area: " + habitat.getArea() + "\n" +
            "Presupuesto: " + habitat.getBudget() + "\n" +
            "Capacidad: " + habitat.getCapacity() + "\n" +
            "Estado: " + habitat.getStatus();
        } else {
            
        }return "No se encontro el habitat con el codigo proporcionado.";
    }

    public String showStaffList(){

        String staffList = "";

        if(employees != null){

            for(int i = 0; i < employees.size(); i++){

                if(employees.get(i) != null){

                    staffList += "\n" + employees.get(i).getUniqueId() + " - " + employees.get(i).getName();
                }
            }
        }

        return staffList;
    }

    public boolean addStaff(String name, String phone, String email, String rol, boolean status){
        Staff newStaff = new Staff(name, phone, email, rol, status);
        return employees.add(newStaff);
}

    
    public String showStaffInformation(String codeStaff){

        Staff staff = searchStaff(codeStaff);

        if(staff != null){

            return "Nombre: " + staff.getName() + "\n" +
            "Codigo: " + staff.getUniqueId() + "\n" +
            "Telefono: " + staff.getPhone() + "\n" +
            "Correo: " + staff.getEmail() + "\n" +
            "Rol: " + staff.getRol() + "\n" +
            "Estado: " + (staff.getStatus() ? "Activo" : "Inactivo");
        } else {
            
        }return "No se encontró el empleado con el código proporcionado.";
    }

    

    private void veterinaryClinic(){
        

        myHabitats[0] =new Habitat("Clinica veterinaria", calculateEnvironmentType(4), 27, 400, 40000000, 25, "activo", null);
            
        
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

    public boolean addHabitats(String name, int environment, double temperature, double area, double budget, int capacity, String status, String assignedStaffCode ){
        int requiredPositions =setPosition(area);
        Staff employee = searchStaff(assignedStaffCode);

        if (employee == null || !employee.getStatus()) {

            return false;
    }

        if((capacityMax + requiredPositions) <= maxHabitats){
                for (int i = 0; i < myHabitats.length; i++) {

                    if (myHabitats[i] == null){

                    myHabitats[i] = new Habitat(name, calculateEnvironmentType(environment),temperature, area, budget, capacity, status, employee);
                    
                        capacityMax += requiredPositions;
                        return true;
        }
    }}
    return false;
}

    public String getHabitats(){

        String habitatsList = "";

        if(myHabitats != null){

            for (int i = 0; i < myHabitats.length; i++) {

                if(myHabitats[i] != null){

                    habitatsList +=  "\n" + myHabitats[i].getName() + " - " + myHabitats[i].getUniqueCode();

                }    
                
            
        }
        if (habitatsList.equals("")){

            return "No hay hábitats registrados en el zoológico.";
        }
    }
    
    return habitatsList;

    }
    public boolean existsHabitat(String codeHabitat) {
        return searchHabitat(codeHabitat) != null;
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

    public Habitat searchHabitat(String codeHabitat){

        for(int i = 0; i < myHabitats.length; i++){

            if(myHabitats[i] != null){

                if(myHabitats[i].getUniqueCode().equalsIgnoreCase(codeHabitat)){

                    return myHabitats[i];
                }
            }
        }

        return null;
    }

    /**
 * Registers a new active animal in the zoo and assigns it to a valid habitat.
 *
 * @param name              The name of the animal.
 * @param species           The species of the animal.
 * @param sex               The sex/gender of the animal (macho or hembra).
 * @param yearOfBirth       The year of birth of the animal.
 * @param weight            The current weight of the animal in kg.
 * @param diet              The diet type (herbivora, carnivora, omnivora, insectivora).
 * @param environmentOption The index of the required environment type.
 * @param countryOfOrigin   The country of origin.
 * @param entryDate         The entry date into the zoo (DD/MM/YYYY).
 * @param healthStatus      The health status (Saludable, Cuarentena, Recuperacion, En observacion).
 * @param codeHabitat       The unique code of the habitat to assign the animal.
 * @return true if the animal was successfully registered and assigned; false otherwise.
 */
public boolean addAnimal(String name, String species, String sex, int yearOfBirth, double weight, 
                        String diet, int environmentOption, String countryOfOrigin, 
                        String entryDate, String healthStatus,String lifeStage, String codeHabitat) {

    Habitat habitat = searchHabitat(codeHabitat);
    if (habitat == null) {
        return false;
    }
    EnvironmentType requiredEnvironmentType = calculateEnvironmentType(environmentOption);

    if (habitat.getStatus().equalsIgnoreCase("activo") &&
        habitat.getEnvironment().equals(requiredEnvironmentType) &&
        habitat.getAnimalCount() < habitat.getCapacity()) {


        Animal newAnimal = new Animal(name, species, sex, yearOfBirth, weight, diet, 
                                    requiredEnvironmentType, countryOfOrigin, entryDate, 
                                    healthStatus,lifeStage, habitat);

        return habitat.addAnimals(newAnimal);
    }

    return false; 
}
    public boolean setStaffName(String codeStaff, String newName){

        Staff staff = searchStaff(codeStaff);

        if(staff != null){

            staff.setName(newName);

            return true; 
        } else {
            
        }return false;
    }
    public boolean setStaffPhone(String codeStaff, String newPhone){

        Staff staff = searchStaff(codeStaff);

        if(staff != null){

            staff.setPhone(newPhone);

            return true;
        } else {
            
        }return false;
    }
    public boolean setStaffEmail(String codeStaff, String newEmail){

        Staff staff = searchStaff(codeStaff);

        if(staff != null){

            staff.setEmail(newEmail);

            return true;
        } else {
            
        }return false;
    }
    public boolean setStaffRol(String codeStaff, String newRol){

        Staff staff = searchStaff(codeStaff);

        if(staff != null){

            staff.setRol(newRol);

            return true;
        } else {
            
        }return false;
    }
    public boolean setStaffStatus(String codeStaff, boolean newStatus){

        Staff staff = searchStaff(codeStaff);

        if(staff != null){

            staff.setStatus(newStatus);

            return true;
        } else {
            
        }return false;
    }
    public boolean setHabitatName(String codeHabitat, String newName){

        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null){

            habitat.setName(newName);

            return true; 
        } else {
            
        }return false;
    }
    public boolean setHabitatTemperature(String codeHabitat, double newTemperature){

        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null){

            habitat.setTemperature(newTemperature);

            return true; 
        } else {
            
        }return false;
    }
    
    
    public boolean setHabitatBudget(String codeHabitat, double newBudget){

        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null){

            habitat.setBudget(newBudget);

            return true; 
        } else {
            
        }return false;
    }
    public boolean setHabitatEnvironmentType(String codeHabitat, int newEnvironment){

        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null){

            habitat.setEnvironment(calculateEnvironmentType(newEnvironment));

            return true; 
        } else {
            
        }return false;
    }
    public boolean setHabitatCapacity(String codeHabitat, int newCapacity){

        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null && newCapacity >= habitat.getAnimalCount()){

            habitat.setCapacity(newCapacity);

            return true;
        } else {
            
        }return false;
    }
    public boolean setHabitatStatus(String codeHabitat, String newStatus){

        Habitat habitat = searchHabitat(codeHabitat);

        if(habitat != null && habitat.getAnimalCount() == 0){

            habitat.setStatus(newStatus);

            return true; 
        } else {
            
        }return false;
    }
    public String getAllAnimalList(){

        String animalList = "";

        for (int i = 0; i < myHabitats.length; i++) {

            if(myHabitats[i] != null){

                animalList+= myHabitats[i].getAnimalList();
            
        }
    }
    return animalList;
}
    public Animal searchAnimalInHabitat(String animalId){

        if (myHabitats != null){
            for (int i = 0; i < myHabitats.length; i++) {
                if(myHabitats[i] != null){

                    Animal animalFound = myHabitats[i].searchAnimal(animalId);

                    if(animalFound != null){

                        return animalFound;
                    }

            }
            }
        }
        return null;
    }
    public boolean setAnimalName(String animalCode, String newName){

        Animal animal = searchAnimalInHabitat(animalCode);

        if(animal != null){
            
            animal.setName(newName);
            return true;
        }
        return false;
    }
    public boolean setAnimalWeight(String codeAnimal, double newWeight) {

        Animal animal = searchAnimalInHabitat(codeAnimal);

        if (animal != null ) {

            animal.setWeight(newWeight);

            return true;
        }
        return false;
}

    public boolean setAnimalDiet(String codeAnimal, String newDiet) {

        Animal animal = searchAnimalInHabitat(codeAnimal);

        if (animal != null) {

            animal.setDiet(newDiet);

            return true;
        }
        return false;
}

    public boolean setAnimalLifeStage(String codeAnimal, String newLifeStage) {

        Animal animal = searchAnimalInHabitat(codeAnimal);

        if (animal != null) {

            animal.setLifeStage(newLifeStage);

            return true;
        }
        return false;
}

    public boolean setAnimalHealthStatus(String codeAnimal, String newHealthStatus) {

        Animal animal = searchAnimalInHabitat(codeAnimal);

        if (animal != null) {

            animal.setHealthStatus(newHealthStatus);

            return true;
        }
        return false;
}
    public boolean animalExist(String codeAnimal){

        if(searchAnimalInHabitat(codeAnimal) != null){

            return true;
        }
    return false;
    }
    public String showAnimalInformation(String codeAnimal){

        Animal animal = searchAnimalInHabitat(codeAnimal);


        return "Nombre: "+animal.getName()+
                "Codigo del animal: "+animal.getAnimalId()+
                "Especie: "+animal.getSpecies()+
                "Sexo: "+animal.getSex()+
                "Peso: "+animal.getWeight()+
                "Edad: "+animal.getAge()+
                "Lugar de origen:  "+animal.getCountryOfOrigin()+
                "Año de entrada al zoologico: "+animal.getEntryDate()+
                "Tipo de dieta: "+animal.getDiet()+
                "Estado de salud: "+animal.getHealthStatus()+
                "Etapa de vida: "+animal.getLifeStage();



    }
}
