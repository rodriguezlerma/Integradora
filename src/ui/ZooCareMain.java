package ui;

import model.Zoo;

import java.util.Scanner;


public class ZooCareMain {
    
    private static Scanner sc = new Scanner(System.in);

    private static Zoo myZoo;

    
    public static void main(String[] args){

        zooMenu();

    }

    public static void zooMenu(){
        
        int menu;

        do{

        System.out.println("\n---Bienvenido al menu de zoologico---\n"
                    +"\n1. Registrar informacion general del zoologico."
                    +"\n2. Consultar informacion general del zoologico."
                    +"\n3. Modificar informacion general del zoologico."
                    +"\n4. Registrar un trabajador."
                    +"\n5. Consultar informacion de un trabajador."
                    +"\n6. Modificar informacion de un trabajador."
                    +"\n7. Registrar un habitat."
                    +"\n8. Consultar informacion de habitat."
                    +"\n9. Modificar informacion de un habitat."
                    +"\n10. Registrar un animal."
                    +"\n11. Modificar datos de animal."
                    +"\n12. Transladar a animal de habitat. "
                    +"\n0. Salir.\n"
                    +"\nIngrese la opcion que requiera acontinuacion: \n");

        menu = sc.nextInt();
        sc.nextLine();
        
        switch (menu) {
            case 1:

                registerGeneralInformation();
                break;

            case 2: 

                showGeneralInformation();
                break;
            case 3: 

                modifyGeneralInformation();
                break;
            case 4: 

                staffRegister();
                break;

            case 5:
                staffInformation();
                break;

            case 6:

                modifyEmployee();
                break;
            case 7:

                habitatsRegister();
                break;

            case 8:

                consultHabitatInformation();
                break;

            case 9:
                habitatModification();
                break;

            case 10:
                registerAnimals();
                break;

            case 11:
                animalModification();

            case 12:
                relocateAnimal();   

        }

        }while( menu != 0);
    }

    public static void registerGeneralInformation(){

        

        System.out.println("Digite el nombre del zoologico: ");
        String name = textValidation();

        System.out.println("Digite la ciudad: ");
        String city =textValidation();

        System.out.println("Digite la direccion: ");
        String address = textValidation();

        System.out.println("Digite el documento del representante legal: ");
        String id = textValidation();

        System.out.println("Digite el nombre del representante legal: ");
        String legalRepresentative = textValidation();

        System.out.println("Digite el presupuesto mensual del zoologico: ");
        double budget = budgetValidation();

        myZoo = new Zoo(name,city,address,id,legalRepresentative,budget); 
        }
    public static void showGeneralInformation(){

        if (myZoo != null){

            System.out.println("\n"+myZoo.generalInformation());
            

        }else{

            System.out.println("Ingresa la informacion general primero.");
        }

    }
    public static String textValidation() {

    String text = sc.nextLine();

    while (text.trim().isEmpty()) {
        System.out.println("El texto no puede estar vacío. Intentelo de nuevo: ");
        text = sc.nextLine();
    }

    return text;
}
    public static void modifyGeneralInformation(){

        if (myZoo != null){

        System.out.println("\n¿Que informacion deseas cambiar?\n"
                            +"\n1. Nombre del zoologico."
                            +"\n2. Ciudad."
                            +"\n3. Direccion."
                            +"\n4. Documento del representante legal."
                            +"\n5. Nombre del representante legal."
                            +"\n6. Presupuesto mensual del zoologico." );

        int generalOptions = sc.nextInt();

        sc.nextLine();

        switch (generalOptions) {
            case 1:
                System.out.println("Digita el nuevo nombre: ");
                String name = textValidation();
                
                myZoo.setName(name);

                break;
            case 2:

                System.out.println("Digita la nueva ciudad: ");
                String city = textValidation();

                myZoo.setCity(city);

                break;

            case 3:

                System.out.println("Digita la nueva direccion: ");
                String address = textValidation();

                myZoo.setAddress(address);

                break;

            case 4:

                System.out.println("Digita el documento del representante legal: ");
                String id = textValidation();

                myZoo.setId(id);

                break;

            case 5:

                System.out.println("Digita el nombre del representante legal: ");
                String legalRepresentative = textValidation();

                myZoo.setLegalRepresentative(legalRepresentative);


                break;

            case 6:

                System.out.println("Digita el nuevo presupuesto mensual: ");
                double budget = budgetValidation();
                
                myZoo.setBudget(budget);

                break;

            
        }
    }else{
        System.out.println("\nIngresa primero los datos generales del zoologico.");
    }
    }
    public static void staffRegister(){
        
        if (myZoo != null){

            System.out.println("\nDigita el nombre del trabajador: ");
            String name = textValidation();

            System.out.println("\nDigite numero de telefono, tiene que tener 10 caracteres: ");
            String phone = sc.nextLine();

            System.out.println("\nDigite el E-mail del trabajador: ");
            String email = textValidation();

            System.out.println("\nDigite el rol de el trabajador (cuidador o veterianario): ");
            String rol = rolValidation();

            boolean status = statusValidation();


            boolean result = myZoo.addStaff(name, phone, email, rol, status);

            if(result){

                System.out.println("\n<<Trabajador registrado correctamente>>");

            }else{

                System.out.println("\n<<No se puede registrar el trabajador>>");
            }

    }}
    public static int environmentValidation(){

            int environment = sc.nextInt();

            while(true){

                if (environment > 0 && environment <= 4){

                    return environment;

                }
                    System.out.println("Datos no validos, intentelo de nuevo: ");
                    environment = sc.nextInt();
            }
    }
    public static String rolValidation(){

        String rol = sc.nextLine();

        while(true){

            if (rol.equals("cuidador") || rol.equalsIgnoreCase("veterinario")){

                return rol;

                }else{

                    System.out.println("\nValor ingresado incorrecto, intentelo de nuevo.\n");

                    rol = sc.nextLine();
    }
}

}
    public static boolean statusValidation(){

        System.out.println("\nIngrese el estado del empleado (Activo o inactivo): ");

        while(true){

            String firstStatus = sc.nextLine().toLowerCase();

            if (firstStatus.equals("activo") || firstStatus.equals("inactivo")){

                if (firstStatus.equals("activo")){

                    return true;
                }else{
                    return false;
                }
                
            }else{

                System.out.println("\nDato no valido. Intentelo de nuevo: ");
            }

        }
    }
    public static double budgetValidation(){

        double budget = sc.nextDouble();
        sc.nextLine();

        while(budget <= 0){

            System.out.println("El presupuesto debe ser mayor o igual a 0. Intentelo de nuevo: ");
            budget = sc.nextDouble();
            sc.nextLine();

        }
        return budget;


    }
    public static void staffInformation(){

    if(myZoo != null){

        System.out.println(myZoo.showStaffList());

        System.out.println("\nDigite el codigo del empleado que desea consultar: ");
        String codeStaff = sc.nextLine();
        

        System.out.println(myZoo.showStaffInformation(codeStaff));
    
    }else{

        System.out.println("\nDebe ingresar los datos generales del zoologico primero.");
    }
}

    public static void modifyEmployee(){

    if(myZoo != null){

        System.out.println("\nDigite el codigo del empleado que desea modificar: ");
        String codeStaff = sc.nextLine();


        if(myZoo.searchStaff(codeStaff) != null){

            System.out.println("\nEmpleado encontrado: " + myZoo.searchStaff(codeStaff).getName());

            System.out.println("\nQue informacion desea modificar del empleado?"
                    + "\n1. Nombre."
                    + "\n2. Telefono."
                    + "\n3. E-mail."
                    + "\n4. Rol."
                    + "\n5. Estado.");

            int modifyOptions = sc.nextInt();
            sc.nextLine();

            switch (modifyOptions) {

                case 1:
                    System.out.println("\nDigite el nuevo nombre del empleado:");
                    String name = textValidation();
                    myZoo.setStaffName(codeStaff, name);
                    System.out.println("Nombre actualizado correctamente.");
                    break;

                case 2:
                    System.out.println("\nDigite el nuevo telefono del empleado:");
                    while (true) {
                        String phone = sc.nextLine();
                        if (phone.length() == 10) {
                            myZoo.setStaffPhone(codeStaff, phone);
                            System.out.println("Telefono actualizado correctamente.");
                            break;
                        } else {
                            System.out.println("El telefono debe tener 10 caracteres. Intentelo de nuevo: ");
                        }
                    }
                case 3:
                    System.out.println("\nDigite el nuevo E-mail del empleado:");
                    String email = textValidation();
                    myZoo.setStaffEmail(codeStaff, email);
                    System.out.println("E-mail actualizado correctamente.");
                    break;

                case 4:
                    System.out.println("\nDigite el nuevo rol del empleado:");
                    String rol = rolValidation();
                    myZoo.setStaffRol(codeStaff, rol);
                    System.out.println("Rol actualizado correctamente.");
                    break;

                case 5:
                    boolean status = statusValidation();
                    myZoo.setStaffStatus(codeStaff, status);
                    System.out.println("Estado actualizado correctamente.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        }else{

            System.out.println("\nNo se encontro el empleado.");
        }

    }else{

        System.out.println("\nDebe ingresar los datos generales del zoologico primero.");
    }
}
    public static void habitatsRegister(){

        if (myZoo != null){

            System.out.println("\n---REGISTRAR HABITAT---\n");
            System.out.println("\nDigita el nombre del habitat: ");
            String name = textValidation();

            System.out.println("Ingrese el tipo de ambiente: ");
            System.out.println(myZoo.getEnvironmentTypeList());
            int environment = environmentValidation();

            System.out.println("\nIngresa la temperatura del habitat: ");
            double temperature = sc.nextDouble();

            System.out.println("\nIngresa la area del habitat: ");
            double area = areaValidation();
            
            System.out.println("\nDigite el presupuesto mensual del habitat: " );
            double budget = budgetValidation();

            System.out.println("\nIngrese la capacidad maxima del habitat: ");
            int capacity = sc.nextInt();
            while(capacity <= 0){

                System.out.println("\nDatos ingresados incorrectos, este dato debe ser mayor a 0. Intentelo de nuevo: ");
                capacity = sc.nextInt();

            }
            sc.nextLine();

            System.out.println("\nDigite el estado del habitat(activo, en mantenimiento, en construccion, retirado): ");

            String status = habitatStatusValidation();

            System.out.println(myZoo.showStaffList());
            System.out.println("Ingrese el Id del personal responsable que asignara al habitat: ");
            String assignedStaffCode = sc.nextLine();



            boolean result = myZoo.addHabitats(name, environment, temperature, area, budget, capacity, status, assignedStaffCode);

            if(result){

                System.out.println("<<Habitat registrado correctamente>>");


            }else{
                System.out.println("<<No se puede registrar el habitat>>");
            }
            
            }else{
            System.out.println("\nInvalido, tiene que existir un zoologico antes.");
            }
        }

    public static String habitatStatusValidation(){

        String status = sc.nextLine().toLowerCase();
        
        while(!(status.equals("activo") || status.equals("en mantenimiento") || status.equals("en construccion") || status.equals("retirado"))){

            System.out.println("\nDato ingresado incorrecto. Intentelo de nuevo: ");
            status = sc.nextLine().toLowerCase();
        }
        return status;
    }
    public static void showHabitats(){

        if (myZoo != null){

            

            System.out.println(myZoo.getHabitats());

            
        }else{

            System.out.println("\nDebe ingresar datos generales del zoologico primero.");
        }
    }
    public static double areaValidation(){

        double area = sc.nextDouble();

        while (!(area > 0 && area <= 400)){

        System.out.println("\nDatos incorrectos, el area debe estar entre 1 y 400. Intentelo de nuevo: ");

        area = sc.nextDouble();
    
    }

    return area;

    }

    public static void consultHabitatInformation(){
        if (myZoo != null){

            System.out.println(myZoo.getHabitats());
            System.out.println("\nDigite el codigo del habitat que desea consultar: ");
            String codeHabitat = sc.nextLine().toLowerCase();

            System.out.println(myZoo.habitatCaracterisics(codeHabitat));
            
    }else{

        System.out.println("Ingrese los datos del zoologico primero");

    }
}

    public static void habitatModification(){
        if(myZoo != null){

            System.out.println(myZoo.getHabitats());
            System.out.println("\nDigite el codigo del habitat que desea modificar: ");
            String codeHabitat = sc.nextLine();

            if(myZoo.searchHabitat(codeHabitat) != null ){

                if(!codeHabitat.equalsIgnoreCase("hbt01")){

                System.out.println("Que informacion desea modificar del habitat?"
                    + "\n1. Nombre."
                    + "\n2. Tipo de ambiente."
                    + "\n3. Temperatura."
                    + "\n4. Presupuesto mensual."
                    + "\n5. Capacidad maxima."
                    + "\n6. Estado.");

                int modifyOptions = sc.nextInt();
                sc.nextLine();

                switch (modifyOptions) {

                    case 1:
                        System.out.println("\nDigite el nuevo nombre del habitat:");
                        String name = textValidation();
                        myZoo.setHabitatName(codeHabitat, name);
                        System.out.println("Nombre actualizado correctamente.");
                        break;

                    case 2:
                        System.out.println("\nDigite el nuevo tipo de ambiente del habitat:");
                        System.out.println(myZoo.getEnvironmentTypeList());
                        int environment = environmentValidation();
                        myZoo.setHabitatEnvironmentType(codeHabitat, environment);
                        System.out.println("Tipo de ambiente actualizado correctamente.");
                        break;

                    case 3:
                        System.out.println("\nDigite la nueva temperatura del habitat:");
                        double temperature = sc.nextDouble();
                        myZoo.setHabitatTemperature(codeHabitat, temperature);
                        System.out.println("Temperatura actualizada correctamente.");
                        break;

                    case 4:
                        System.out.println("\nDigite el nuevo presupuesto mensual del habitat:");
                        double budget = budgetValidation();
                        myZoo.setHabitatBudget(codeHabitat, budget);
                        System.out.println("Presupuesto mensual actualizado correctamente.");
                        break;

                    case 5:
                        System.out.println("\nDigite la nueva capacidad maxima del habitat:");
                        int capacity = sc.nextInt();
                        while(capacity <= 0){

                            System.out.println("\nDatos ingresados incorrectos, este dato debe ser mayor a 0. Intentelo de nuevo: ");
                            capacity = sc.nextInt();
                            

                        }
                        
                        if(myZoo.setHabitatCapacity(codeHabitat, capacity)){

                            System.out.println("Capacidad maxima actualizada correctamente.");
                        }else{
                            System.out.println("No se pudo actualizar la capacidad maxima.");
                        }
                        sc.nextLine();
                        break;
                    case 6:
                        System.out.println("\nDigite el nuevo estado del habitat(activo, en mantenimiento, en construccion, retirado): ");
                        String status = habitatStatusValidation();
                            if((status.equals("en mantenimiento") || status.equals("en construccion") || status.equals("retirado"))&& myZoo.searchHabitat(codeHabitat).getAnimalCount() > 0){
                            
                                System.out.println("No se puede cambiar el estado del habitat a " + status + " porque tiene animales asignados.");
                                break;
                            }else {
                                myZoo.setHabitatStatus(codeHabitat, status);
                        }
                        myZoo.setHabitatStatus(codeHabitat, status);
                        
                        System.out.println("Estado actualizado correctamente.");
                        break;

                    default:
                        System.out.println("Opcion no valida.");
                        break;
            }
        }
    }else{ 
        System.out.println("\nNo puede modificar la clinica veterinaria.");
    }
    }else{
            System.out.println("\nNo se encontro el habitat o intento modificar la clinica veterinaria.");
        }
}
    public static void  registerAnimals(){

        if(myZoo != null){
            System.out.println("Ingrese el nombre del animal: ");
            String name = textValidation();

            System.out.println("Digite la especie del animal: ");
            String species = textValidation();

            System.out.println("Digite el sexo del animal (macho or hembra):");
            String sex = sexValidation();

            System.out.println("Digite el año de nacimiento del animal (YYYY): ");
            int yearOfBirth = yearValidation();
            sc.nextLine();

            System.out.println("Digite el peso del animal: ");
            double weight = weightValidation();
            sc.nextLine();

            System.out.println("Tipo de dieta:\n\nherbivora\ncarnivora\nomnivora\ninsectivora\n\nIngrese el correspondiente a su caso: ");
            String diet = dietValidation();

            System.out.println(myZoo.getEnvironmentTypeList());
            int environment = environmentValidation();
            sc.nextLine();

            System.out.println("Digite el lugar de origen del animal: ");
            String countryOfOrigin = textValidation();
            
            System.out.println("Ingrese la fecha de entrada del animal con el siguiente formato: (DD/MM/AAAA): ");
            String entryDate = textValidation();

            System.out.println("Digite el estado de salud del animal: \n\nSaludable \nCuarentena \nRecuperacion \nEn observacion: ");
            String healthStatus = healthStatusValidation();

            System.out.println("Digite el estado de vida del animal (juvenil o adulto): ");
            String lifeStage = sc.nextLine().toLowerCase();
            while(!(lifeStage.equals("juvenil") || lifeStage.equals("adulto"))){

                System.out.println("Datos incorrectos, intentelo de nuevo: ");
                lifeStage = sc.nextLine().toLowerCase();

            }

            System.out.println("¿A que habitat sera asignado?: ");
            String codeHabitat = habitatCodeValidation();


            boolean result = myZoo.addAnimal(name, species, sex, yearOfBirth, weight, diet, 
                                        environment, countryOfOrigin, entryDate, 
                                        healthStatus,lifeStage, codeHabitat);
            if (result) {
                System.out.println("\n<< Animal registrado y asignado exitosamente >>");
            } else {
                System.out.println("\n<< No se pudo registrar el animal. Verifique que el codigo del habitat exista, este activo, sea compatible con el ambiente requerido y tenga capacidad disponible >>");
            }

            } else {
                System.out.println("Se tiene que registrar el zoologico primero.");
            }
        }
        
    public static void animalModification(){

        if (myZoo != null){

            if(!myZoo.getAllAnimalList().equals("")){

                System.out.println(myZoo.getAllAnimalList());
                System.out.println("Digite el codigo del animal que desea modificar: ");
                String animalId = sc.nextLine();
                if(myZoo.animalExist(animalId)){

                    System.out.println("\nOpciones modificables:\n"+
                                        "\n1. Nombre."+
                                        "\n2. Peso."+
                                        "\n3. Tipo de dieta."+
                                        "\n4. Etapa de vida."+
                                        "\n5. Estado de salud."+
                                        "\n\nSeleccione la opcion que requiera: ");
                    
                    int option = sc.nextInt();
                    sc.nextLine();

                    switch (option) {

                        case 1:
                            System.out.println("\nDigite el nuevo nombre:");
                            String name = textValidation();
                            myZoo.setAnimalName(animalId, name);
                            System.out.println("Nombre actualizado correctamente.");
                            break;

                        case 2:
                            System.out.println("\nDigite el nuevo peso (kg):");
                            double weight = weightValidation();
                            sc.nextLine();
                            myZoo.setAnimalWeight(animalId, weight);
                            System.out.println("Peso actualizado correctamente.");
                            break;

                        case 3:
                            System.out.println("\nDigite el nuevo tipo de dieta (herbivora, carnivora, omnivora, insectivora):");
                            String diet = dietValidation();
                            myZoo.setAnimalDiet(animalId, diet);
                            System.out.println("Tipo de dieta actualizado correctamente.");
                            break;

                        case 4:
                            System.out.println("\nDigite la nueva etapa de vida (juvenil o adulto):");
                            String lifeStage = sc.nextLine().toLowerCase();
                            while(!(lifeStage.equals("juvenil") || lifeStage.equals("adulto"))){
                            System.out.println("Datos incorrectos, intentelo de nuevo: ");
                            lifeStage = sc.nextLine().toLowerCase();

                            }

                            System.out.println("Etapa de vida actualizada correctamente.");
                            break;

                        case 5:
                            System.out.println("\nDigite el nuevo estado de salud (Saludable, Cuarentena, Recuperacion, En observacion):");
                            String healthStatus = healthStatusValidation();
                            myZoo.setAnimalHealthStatus(animalId, healthStatus);
                            System.out.println("Estado de salud actualizado correctamente.");
                            break;

                        default:
                            System.out.println("Opcion no valida.");
                            break;
                            }


                }else{

                    System.out.println("\nEl codigo digitado no esta asociado a ningun animal.");
                }

        }else{
            System.out.println("No hay animales registrados. ");
        }
        
    }else{
        System.out.println("\nRealice los datos generales del zoologico primero.");
    }
}

    public static void relocateAnimal() {
    if (myZoo != null) {
        System.out.println("\n--- TRASLADAR ANIMAL DE HABITAT ---");

        System.out.println("\nDigite el codigo del animal a trasladar: ");
        String codeAnimal = sc.nextLine();

        String animalName = myZoo.searchAnimalInHabitat(codeAnimal).getName();

        if (animalName != null) {
            System.out.println("Animal a trasladar: " + animalName);

            System.out.println("\nSeleccione el codigo del nuevo habitat de destino:");
            System.out.println(myZoo.getHabitats());
            String newCodeHabitat = sc.nextLine();

            boolean success = myZoo.relocateAnimal(codeAnimal, newCodeHabitat);

            if (success) {
                System.out.println("\n<< Animal trasladado exitosamente al nuevo habitat >>");
            } else {
                System.out.println("\n<< No se pudo realizar el traslado, revise que lo codigos sean de entidades existentes >> ");
            }

        } else {
            System.out.println("\nNo se encontro un animal activo con el codigo proporcionado.");
        }

    } else {
        System.out.println("\nDebe ingresar los datos generales del zoologico primero.");
    }
}

    
    public static String sexValidation(){

        String sex = sc.nextLine();

        while(true){

            if (sex.equals("macho") || sex.equals("hembra")){

                return sex;
                
            }else{

                System.out.println("Intentelo de nuevo: ");
                sex = sc.nextLine();

                
            }

        }
    }
    public static int yearValidation(){

        int year = sc.nextInt();
        
        while(year <= 0 || year > 2026){

            System.out.println("Datos incorrectos, el año tiene que estar entre 1 y 2026. Intentelo de nuevo: ");
            year = sc.nextInt();
        }
        return year;
    }
    public static String dietValidation(){

        String diet = sc.nextLine();

        while(true){

            if (diet.equals("herbivora") || diet.equals("carnivora") || diet.equals("omnivora") || diet.equals("insectivora")){
                
            return diet;

            }else{
                System.out.println("\nDatos incorretos. Intentelo de nuevo: ");
            }
        }
    }
    public static String healthStatusValidation(){

        String healthSatus = sc.nextLine().toLowerCase();

        while(!(healthSatus.equals("saludable") || healthSatus.equals("cuarentena") || healthSatus.equals("recuperacion") || healthSatus.equals("en observacion"))){
        
            System.out.println("Datos incorrectos, intentelo de nuevo: ");
            healthSatus = sc.nextLine().toLowerCase();
    }
    return healthSatus;
    }
    
    public static double weightValidation(){

        double weight = sc.nextDouble();
        while(weight <= 0){
                System.out.println("\nDatos incorrectos, el peso no puede ser menor o igual a cero. Intentelo de nuevo.");
                weight = sc.nextDouble();
            }
        return weight;

        
    }
    public static String habitatCodeValidation() {

        System.out.println(myZoo.getHabitats());
        System.out.println("\nDigite el codigo del habitat: ");
        String codeHabitat = sc.nextLine().toUpperCase();

        while (!myZoo.existsHabitat(codeHabitat)) {
            System.out.println("Incorrecto, el codigo no existe. Intentelo de nuevo: ");
            codeHabitat = sc.nextLine().toLowerCase();
    }

    return codeHabitat;
}
}   
