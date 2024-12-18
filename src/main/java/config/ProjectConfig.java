package config;

import components.User;
import components.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("components")
public class ProjectConfig {

    @Bean("Audi")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }
    @Bean("Honda")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }
    @Bean("BMW")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("BMW");
        return veh;
    }
}
