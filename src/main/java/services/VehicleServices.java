package services;

import interfaces.SpeakerImp;
import interfaces.TyresImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON) // SCOPE_SINGLETON is the default scope of a bean in Spring
                                       // So if you don't declare the @Scope for the @Component it still created as SCOPE_SINGLETON

// Singleton in Spring is different from Singleton pattern.
// They still do the job of make sure only one object type is existing, but they live in different context.
// - Singleton in Spring live in Spring Container context.
// - Singleton pattern live in JVM context
public class VehicleServices {

    @Autowired
    private SpeakerImp speaker;
    @Autowired
    private TyresImp tyres;

    public SpeakerImp getSpeaker() {
        return speaker;
    }
    public void playMusic(){
        String music = speaker.makeSound();
        System.out.println(music);
    }

    public void moveVehicle(){
        String status = tyres.moveCar();
        System.out.println(status);
    }

    public SpeakerImp getSpeakers() {
        return speaker;
    }

    public void setSpeakers(SpeakerImp speakers) {
        this.speaker = speakers;
    }

    public TyresImp getTyres() {
        return tyres;
    }

    public void setTyres(TyresImp tyres) {
        this.tyres = tyres;
    }


}
