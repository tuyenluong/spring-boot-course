package com.jeremy.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("Jeremy") //Eager instantiation when you don't use @Lazy
@Lazy
public class User {

    private Vehicle vehicle;
    private String name = "Kaido";

    public User (Vehicle vehicle){
        // This String will print before 2 lines in the com.jeremy.main class
        System.out.println("Jeremy bean created by Spring");
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello(){
        System.out.println("Hello from the other side");
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Autowired
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString(){
        return "- "+ name;
    }
}
