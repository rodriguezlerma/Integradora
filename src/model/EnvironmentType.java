package model;

public enum EnvironmentType{
    
    LAND("Terrestre"),
    WATER("Acuatico"),
    AVIARY("Aviario"),
    MEDICAL("Medico");

    private String typeName;

    EnvironmentType(String typeName){

        this.typeName = typeName;

    }
    public String getTypeName(){

        return typeName;
    }
}
