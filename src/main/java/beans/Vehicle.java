package beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import services.VehicleServices;

@Component
public class Vehicle {
    private String name = "Toyota";

    @Autowired
    public Vehicle(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    public VehicleServices getVehicleServices() {
        return vehicleServices;
    }

    public void setVehicleServices(VehicleServices vehicleServices) {
        this.vehicleServices = vehicleServices;
    }

    private VehicleServices vehicleServices;

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
