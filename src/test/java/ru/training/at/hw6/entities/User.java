package ru.training.at.hw6.entities;

public class User {

    public static final User ROMAN = new User("Roman", "Jdi1234");

    private String username;
    private String password;

    User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

}
