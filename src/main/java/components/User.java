package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printHello(){
        System.out.println("Hello from the other side");
    }

    private String name = "Kaido";

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Autowired
    private Vehicle vehicle;

    @Override
    public String toString(){
        return "- "+ name;
    }
}
