package model;

public class Staff {

   private static int nextId = 1;

   private String uniqueId;
   private String name;
   private String phone;
   private String email;
   private String rol;
   private boolean status;     
   
   public Staff(String name, String phone, String email, String rol, boolean status){


      this.name = name;
      this.phone = phone;
      this.email = email;
      this.rol = rol;
      this.status = status;
   
      this.uniqueId = generateUniqueId();
   }
   public String generateUniqueId() {
      String id = "STF0" + nextId;
      nextId++;
      return id;
   }

   public String getUniqueId() {

      return uniqueId;
   }

   public String getName() {
      return name;
   }

   public String getPhone() {
      return phone;
   }

   public String getEmail() {
      return email;
   }

   public String getRol() {
      return rol;
   }

   public boolean getStatus() {
      return status;
   }
   public void setName(String name) {

      this.name = name;

   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public void setRol(String rol) {
      this.rol = rol;
   }
   public void setStatus(boolean status) {

      this.status = status;
   }

}
