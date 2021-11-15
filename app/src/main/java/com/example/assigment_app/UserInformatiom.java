package com.example.assigment_app;

public class UserInformatiom {
    public String name;
    public String surname;
    public String phoneno;
    public UserInformatiom(){
    }
    public UserInformatiom( String name,String surname,String phoneno){
        this.name = name;
        this.surname = surname;
        this.phoneno= phoneno;
    }
    public String getUserName(){
        return name;
    }
    public String getUserSurname(){
        return surname;
    }
    public String getUserPhone(){
        return phoneno;
    }
}
