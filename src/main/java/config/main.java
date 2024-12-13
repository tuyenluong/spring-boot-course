package config;

import components.User;
import components.Vehicle;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        User user = context.getBean(User.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("User name is: "+ user.getName());
        System.out.println("Vehicle name is: "+ vehicle.getName());
        System.out.println("User vehicle is: "+ user.getVehicle());
    }
}
