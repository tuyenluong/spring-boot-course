import beans.User;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.impl.Song;
import services.VehicleServices;

public class main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        VehicleServices vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());
        Song song = new Song();
        song.setTitle("Baby");
        song.setSingerName("Justin Bieber");
        boolean vehicleStarted = true;
        String moveVehicleStatus = vehicleServices.moveVehicle(vehicleStarted);
        String playMusicStatus = vehicleServices.playMusic(vehicleStarted,song);
        String applyBrakeStatus = vehicleServices.applyBrake(vehicleStarted);

        // AOP approach helps us handle all cross-cutting concern
        // that is not relative with the core business like
        // logging, validation, manage transactions, exception handle, debug,...
        // Resources: https://www.geeksforgeeks.org/aspect-oriented-programming-and-aop-in-spring-framework/
    }
}
