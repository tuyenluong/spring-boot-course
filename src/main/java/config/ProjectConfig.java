package config;

import components.User;
import components.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("components")
public class ProjectConfig {
    @Bean
    public Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Toyota");
        return vehicle;
    }
    @Bean
    public User user(Vehicle vehicle){
        User user = new User();
        user.setName("Kaido");
        user.setVehicle(vehicle);
        return user;
    }
}
