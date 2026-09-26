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
        double budget = sc.nextDouble();
        do{
            if (budget >= 0){

                break;
                
            }
            System.out.println("Intentelo de nuevo: ");
            budget = sc.nextDouble();

        }while(true);
        sc.nextLine();

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
                double budget = sc.nextDouble();
                do{
                if (budget >= 0){

                    break;
                
                }
                System.out.println("Intentelo de nuevo: ");
                budget = sc.nextDouble();

                }while(true);


                myZoo.setBudget(budget);
                
                sc.nextLine();

                break;

            
        }
    }else{
        System.out.println("\nIngresa primero los datos generales del zoologico.");
    }
    }

    public static void staffRegister(){

        System.out.println("Digita el nombre del trabajador: ");
        String name = validarTexto();

        System.out.println("Digite numero de telefono, tiene que tener 10 caracteres: ");
        String phone = sc.nextLine();


    }

    public static String numberValidation(){

        String text = sc.nextLine();

        while (text.length() == 10) {

            for (int i = 0; i < text.length(); i++){

                char digit = text.charAt(i);

                if (!Character.isDigit(digit)){

                   
                }else{

                }

                }
        }
            

    }


}