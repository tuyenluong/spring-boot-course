package components;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name = "Toyota";

    @Override
    public String toString(){
        return "- "+ name;
    }
}
