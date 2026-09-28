package model;

public class Staff {

   private static int nextId = 1;

   private int uniqueId;
   private String name;
   private String phone;
   private String email;
   private String rol;
   private boolean status;     
   
   public Staff(String name, String phone, String email, String rol, boolean status){

      this.uniqueId = nextId;
      nextId++;
      this.name = name;
      this.phone = phone;
      this.email = email;
      this.rol = rol;
      this.status = status;
   }

}


