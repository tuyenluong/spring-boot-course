import beans.User;
import beans.Vehicle;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        User user = context.getBean(User.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("User name is: "+ user.getName());
        System.out.println("Vehicle name is: "+ user.getVehicle().getName());
        System.out.println("User vehicle is: "+ user.getVehicle());
        System.out.println("Vehicle speaker is: "+ user.getVehicle().getVehicleServices().getSpeaker());
        user.getVehicle().getVehicleServices().getSpeaker().makeSound();
        System.out.println("Vehicle tyres is: "+ user.getVehicle().getVehicleServices().getTyres());
        user.getVehicle().getVehicleServices().getTyres().moveCar();
    }
}
