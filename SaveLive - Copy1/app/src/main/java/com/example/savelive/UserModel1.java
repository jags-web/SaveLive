package com.example.savelive;

public class UserModel1 {
  private String name,number,email;

    public UserModel1(){

    }

    public UserModel1(String name, String email){
        this.name=name;
        this.email=email;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
