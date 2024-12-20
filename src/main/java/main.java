import beans.User;
import beans.Vehicle;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.VehicleServices;

public class main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices1 = context.getBean(VehicleServices.class);
        VehicleServices vehicleServices2 = context.getBean("vehicleServices",VehicleServices.class);
        System.out.println("Hashcode of the vehicleServices1 object: " + vehicleServices1.hashCode());
        System.out.println("Hashcode of the vehicleServices2 object: " + vehicleServices2.hashCode());
        if(vehicleServices1==vehicleServices2){
            System.out.println("VehiclesService bean is a singleton scoped bean");
        }else{
            System.out.println("VehiclesService bean is not singleton scoped bean");
        }
    }
}
