package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    private Vehicle vehicle;
    private String name = "Kaido";

    @Autowired
    // Since Spring 6.1.0 version, Spring is no longer support Autowiring the beans using their names anymore
    // So even I'm using the "vehicle1" bean in the ProjectConfig class, it still not able to detect what bean it should using
    // It will produce "NoUniqueBeanDefinitionException", " expected single matching bean but found 4: vehicle,vehicle1,vehicle2,vehicle3"
    public User (Vehicle vehicle1){
        System.out.println("User bean created by Spring");
        this.vehicle = vehicle1;
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

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString(){
        return "- "+ name;
    }
}
