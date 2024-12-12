package components;

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

    private String name;

}
