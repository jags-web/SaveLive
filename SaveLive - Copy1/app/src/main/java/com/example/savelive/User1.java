package com.example.savelive;

public class User1 {
    private String name,email,phone,number;
    public User1(){

    }
    public User1(String name, String email,String phone,String number){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.number = number;



    }
    public  String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(){
        this.number = number;
    }

}
