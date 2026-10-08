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



        }

        }while( menu != 0);
    }

    public static void registerGeneralInformation(){

        

        System.out.println("Digite el nombre del zoologico: ");
        String name = validarTexto();

        System.out.println("Digite la ciudad: ");
        String city =validarTexto();

        System.out.println("Digite la direccion: ");
        String address = validarTexto();

        System.out.println("Digite el documento del representante legal: ");
        String id = validarTexto();

        System.out.println("Digite el nombre del representante legal: ");
        String legalRepresentative = validarTexto();

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
    public static String validarTexto() {

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
                String name = validarTexto();
                
                myZoo.setName(name);

                break;
            case 2:

                System.out.println("Digita la nueva ciudad: ");
                String city = validarTexto();

                myZoo.setCity(city);

                break;

            case 3:

                System.out.println("Digita la nueva direccion: ");
                String address = validarTexto();

                myZoo.setAddress(address);

                break;

            case 4:

                System.out.println("Digita el documento del representante legal: ");
                String id = validarTexto();

                myZoo.setId(id);

                break;

            case 5:

                System.out.println("Digita el nombre del representante legal: ");
                String legalRepresentative = validarTexto();

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
            String name = validarTexto();

            System.out.println("\nDigite numero de telefono, tiene que tener 10 caracteres: ");
            String phone = sc.nextLine();

            System.out.println("\nDigite el E-mail del trabajador: ");
            String email = validarTexto();

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
    public static double validationGreaterThanzero(){

        double number = sc.nextDouble();

        while (number > 0) {
            
        
            if (number < 0 ){

                System.out.println("\nDato ingresado incorrecto, debe ser un numero mayor a 0. Intentelo de nuevo: ");
                number = sc.nextDouble();
    }   
    }
    return number;
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
    

        Staff employee = myZoo.searchStaff(codeStaff);

        if(employee != null){

            System.out.println("\nEmpleado encontrado: " + employee.getName());

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
                    String name = validarTexto();
                    employee.setName(name);
                    System.out.println("Nombre actualizado correctamente.");
                    break;

                case 2:
                    System.out.println("\nDigite el nuevo telefono del empleado:");
                    String phone = sc.nextLine();
                    employee.setPhone(phone);
                    System.out.println("Telefono actualizado correctamente.");
                    break;

                case 3:
                    System.out.println("\nDigite el nuevo E-mail del empleado:");
                    String email = validarTexto();
                    employee.setEmail(email);
                    System.out.println("E-mail actualizado correctamente.");
                    break;

                case 4:
                    System.out.println("\nDigite el nuevo rol del empleado:");
                    String rol = rolValidation();
                    employee.setRol(rol);
                    System.out.println("Rol actualizado correctamente.");
                    break;

                case 5:
                    boolean status = statusValidation();
                    employee.setStatus(status);
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
            String name = validarTexto();

            System.out.println("Ingrese el tipo de ambiente: ");
            System.out.println(myZoo.getEnvironmentTypeList());
            int environment = environmentValidation();

            System.out.println("\nIngresa la temperatura del habitat: ");
            double temperature = sc.nextDouble();

            System.out.println("\nIngresa la area del habitat: ");
            double area = areaValidation();

            int position = setPosition(area);

            
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



            boolean result = myZoo.addHabitats(name, environment, temperature, area, budget, capacity, status);

            if(result){

                System.out.println("<<Habitat registrado correctamente>>");

                myZoo.sumCapacityMax(capacity);

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
            String codeHabitat = sc.nextLine();

            System.out.println(myZoo.habitatCaracterisics(codeHabitat));
            
    }
    }
    public static int setPosition(double area){

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
    public static void modifiHabitats(){
        if(myZoo != null){

            System.out.println(myZoo.getHabitats());
            System.out.println("\nDigite el codigo del habitat que desea modificar: ");
            String codeHabitat = sc.nextLine();

            myZoo.
        }
    }
}
    