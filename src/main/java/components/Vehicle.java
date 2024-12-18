package components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name = "Toyota";

    // It will resolve in failure due to it Autowired circling with each other between Vehicle and User Beans
    // Lead to "BeanCurrentlyInCreationException" error
    // With message  "Requested bean is currently in creation: Is there an unresolvable circular reference or an asynchronous initialization dependency?"
    @Autowired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "- "+ name;
    }
}
